pragma solidity ^0.4.24;


import "./Table.sol";

contract Donuts {
    // event
    event BuyDonuts(int256 ret, string owner_sign, string donut_name, int256 detail);
    event TakeDonuts(int256 ret, string owner_sign, string new_sign, int256 detail);

    constructor() public {
        // 构造函数中创建t_asset表
        createTable();
    }

    function createTable() private {
        TableFactory tf = TableFactory(0x1001);
        // 甜甜圈管理表, key : account, field : asset_value
        // |  资产账户(主键)      |     资产金额       |    资产金额       |     资产金额       |
        // |-------------------- |-------------------|-------------------|-------------------|
        // |        account      |    asset_value    |    asset_value    |    asset_value    |
        // |---------------------|-------------------|-------------------|-------------------|
        //
        // 创建表
        tf.createTable("t_donuts", "owner_sign", " donut_name , detail");
    }

    function openTable() private returns (Table) {
        TableFactory tf = TableFactory(0x1001);
        Table table = tf.openTable("t_donuts");
        return table;
    }

    /*
    描述 : 根据资产账户查询资产金额
    参数 ：
            account : 资产账户

    返回值：
            参数一： 成功返回0, 账户不存在返回-1
            参数二： 第一个参数为0时有效，资产金额
    */
    function select(string owner_sign) public constant returns (int256, string memory, int256) {
        // 打开表
        Table table = openTable();
        // 查询
        Entries entries = table.select(owner_sign, table.newCondition());
        string memory value = "0";
        if (0 == uint256(entries.size())) {
            return (- 1, value, 0);
        } else {
            Entry entry = entries.get(0);
            return (0, string(entry.getString("donut_name")), int256(entry.getInt("detail")));
        }
    }

    /*
    描述 : 资产注册
    参数 ：
            account : 资产账户
            amount  : 资产金额
    返回值：
            0  资产注册成功
            -1 资产账户已存在
            -2 其他错误
    */
    function register(string owner_sign, string donut_name, int256 detail) public returns (int256){
        int256 ret_code = 0;
        int256 ret = 0;
        string memory value1;
        int256 value2;
        // 查询账户是否存在
        (ret, value1, value2) = select(owner_sign);
        if (ret != 0) {
            Table table = openTable();

            Entry entry = table.newEntry();
            entry.set("owner_sign", owner_sign);
            entry.set("donut_name", donut_name);
            entry.set("detail", detail);
            // 插入
            int count = table.insert(owner_sign, entry);
            if (count == 1) {
                // 成功
                ret_code = 0;
            } else {
                // 失败? 无权限或者其他错误
                ret_code = - 2;
            }
        } else {
            // 账户已存在
            ret_code = - 1;
        }

        emit BuyDonuts(ret_code, owner_sign, donut_name, detail);

        return ret_code;
    }

    function deleteDonuts(string owner_sign) public returns (int256){
        // 打开表
        Table table = openTable();
        // delete
        int256 value = table.remove(owner_sign, table.newCondition());
        if (0 == value) {
            return (- 1);
        } else {
            return (value);
        }
    }

    /*
    描述 : 资产转移
    参数 ：
            from_account : 转移资产账户
            to_account ： 接收资产账户
            amount ： 转移金额
    返回值：
            0  资产转移成功
            -1 转移资产账户不存在
            -2 接收资产账户不存在
            -3 金额不足
            -4 金额溢出
            -5 其他错误
    */
    function transfer(string owner_sign, string new_sign, int256 detail) public returns (int256) {
        // 查询转移资产账户信息
        int ret_code = 0;
        int256 ret = 0;
        int256 from_donuts_detail = 0;
        int256 to_donuts_detail = 0;
        string memory from_donuts_name;
        string memory to_donuts_name;

        // 转移账户是否存在?
        (ret, from_donuts_name, from_donuts_detail) = select(owner_sign);
        if (ret != 0) {
            ret_code = - 1;
            // 转移账户不存在
            emit TakeDonuts(ret_code, owner_sign, new_sign, detail);
            return ret_code;

        }

        // 接受账户是否存在?
        (ret, to_donuts_name, to_donuts_detail) = select(new_sign);
        if (ret != 0) {
            ret_code = - 2;
            // 接收资产的账户不存在
            emit TakeDonuts(ret_code, owner_sign, new_sign, detail);
            return ret_code;
        }

        if (from_donuts_detail < detail) {
            ret_code = - 3;
            // 转移资产的账户金额不足
            emit TakeDonuts(ret_code, owner_sign, new_sign, detail);
            return ret_code;
        }

        if (to_donuts_detail + detail < to_donuts_detail) {
            ret_code = - 4;
            // 接收账户金额溢出
            emit TakeDonuts(ret_code, owner_sign, new_sign, detail);
            return ret_code;
        }

        Table table = openTable();

        Entry entry0 = table.newEntry();
        entry0.set("owner_sign", owner_sign);
        entry0.set("donut_name", from_donuts_name);
        entry0.set("detail", int256(from_donuts_detail - detail));
        // 更新转账账户
        int count = table.update(owner_sign, entry0, table.newCondition());
        if (count != 1) {
            ret_code = - 5;
            // 失败? 无权限或者其他错误?
            emit TakeDonuts(ret_code, owner_sign, new_sign, detail);
            return ret_code;
        }

        Entry entry1 = table.newEntry();
        entry1.set("owner_sign", new_sign);
        entry1.set("donut_name", to_donuts_name);
        entry1.set("detail", int256(to_donuts_detail + detail));
        // 更新接收账户
        table.update(new_sign, entry1, table.newCondition());

        emit TakeDonuts(ret_code, owner_sign, new_sign, detail);

        return ret_code;
    }
}
