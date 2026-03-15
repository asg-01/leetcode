// Last updated: 3/15/2026, 11:25:45 PM
1class Fancy {
2   HashMap<Integer,Long> h;
3   HashMap<Integer,Integer> map;
4   ArrayList<Integer> list=new ArrayList<Integer>(); // for add value=0, for multiply val=1
5   ArrayList<Integer> l=new ArrayList<Integer>();
6   int i=0;
7   int flag=0;
8   long prod=-1,sum=0;
9    public Fancy() {
10        h=new HashMap<Integer,Long>();
11        map=new HashMap<Integer,Integer>(); 
12    }
13    
14    public void append(int val) {
15        if(prod!=-1)
16        {
17            list.add(1);
18            l.add((int)prod);
19            prod=-1;
20        }
21        if(sum!=0)
22        {
23            list.add(0);
24            l.add((int)sum);
25            sum=0;
26        }
27        long x=val;
28        h.put(i,x);
29        map.put(i,list.size());
30        i++;
31    }
32    
33    public void addAll(int inc) {
34        if(prod!=-1)
35        {
36            list.add(1);
37            l.add((int)prod);
38            prod=-1;
39        }
40        sum=sum+inc;
41    }
42    
43    public void multAll(int m) {
44        if(sum!=0)
45        {
46            list.add(0);
47            l.add((int)sum);
48            sum=0;
49        }
50        if(prod==-1)
51        {
52           prod=1;
53        }
54        prod=(prod*m)%1000000007;
55    }
56    
57    public int getIndex(int idx) {
58        if(prod!=-1)
59        {
60            list.add(1);
61            l.add((int)prod);
62            prod=-1;
63        }
64        if(sum!=0)
65        {
66            list.add(0);
67            l.add((int)sum);
68            sum=0;
69        }
70        if(!h.containsKey(idx))
71        {
72            return -1;
73        }
74        long val=h.get(idx);
75        for(int j=map.get(idx);j<list.size();j++)
76        {
77            if(list.get(j)==0)
78            {
79                val+=l.get(j);
80                val=val%(1000000007);
81            }
82            else
83            {
84                val=val*(l.get(j));
85                val=val%(1000000007);
86            }
87        }
88
89        return (int)val;
90    }
91}