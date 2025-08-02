class Bank {

    long[] bal;

    public Bank(long[] balance) {

        bal = balance;

    }

    public boolean transfer(int account1, int account2, long money) {

        if (isValid(account1) && isValid(account2) && has(account1, money)) {

            bal[account1 - 1] = bal[account1 - 1] - money;
            bal[account2 - 1] = bal[account2 - 1] + money;
            return true;
        }

        return false;

    }

    public boolean deposit(int account, long money) {

        if (isValid(account)) {
            bal[account - 1] = bal[account - 1] + money;
            return true;
        }
        return false;

    }

    public boolean withdraw(int account, long money) {
        if (isValid(account) && has(account, money)) {
            bal[account - 1] = bal[account - 1] - money;
            return true;
        }
        return false;

    }

    public boolean isValid(int n) {
        if (n - 1 >= 0 && n - 1 < bal.length) {
            return true;
        }
        return false;
    }

    public boolean has(int n, long amt) {
        if (bal[n - 1] >= amt) {
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */