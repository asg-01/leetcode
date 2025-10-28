// Last updated: 10/29/2025, 3:07:25 AM
class Solution {
    public int nextBeautifulNumber(int n) {
       int[] map = new int[10];
       Arrays.fill(map,0); 
       int k=n;
       int p,x;
       boolean dec = true;
       while(dec == true){
            Arrays.fill(map,0);
            k++;
            x = k;
            while(x>0){
                if(x%10==0){
                    k++;
                    x = k;
                    Arrays.fill(map,0);
                    continue;
                }
                p = x%10;  
                map[p]+=1;
                if(map[p]>p){
                    k++;
                    x=k;
                    Arrays.fill(map,0);
                    continue;
                }
                x = x/10;
            }
            dec = false;
            for(int i = 0;i<10;i++){
                if(map[i]!=0){
                    if(map[i]!=i){
                        dec = true;
                    }
                }
            }
        }
        return k;
    }
}