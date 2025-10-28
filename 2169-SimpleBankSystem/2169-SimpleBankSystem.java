// Last updated: 10/29/2025, 3:07:28 AM
class Bank {
    List<Long>list=new ArrayList<>();
    public Bank(long[] balance) {
        for(int i=0;i<balance.length;i++){
            list.add(balance[i]);
        }
    }
    
    public boolean transfer(int account1, int account2, long money) {
        if(account1-1<list.size()&&account2-1<list.size()&&list.get(account1-1)>=money){
             long val=list.get(account1-1);
             long res=val-money;
             list.set(account1-1,res);
             list.set(account2-1,list.get(account2-1)+money);
             return true;
        }
        return false;
    }
    
    public boolean deposit(int account, long money) {
        if(account-1<list.size()){
            list.set(account-1,list.get(account-1)+money);
            return true;
        }
        return false;
    }
    
    public boolean withdraw(int account, long money) {
        if(account-1<list.size()&&list.get(account-1)>=money){
            list.set(account-1,list.get(account-1)-money);
            return true;
        }
        return false;
    }
}

