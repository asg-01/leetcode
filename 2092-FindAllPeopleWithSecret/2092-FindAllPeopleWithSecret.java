// Last updated: 12/20/2025, 12:32:37 AM
1class Solution {
2    public List<Integer> findAllPeople(int n, int[][] meet, int fp) {
3        // Group Meetings in increasing order of time
4        Map<Integer,List<int[]>> timeMeetings = new TreeMap<>();
5        for(int[] m : meet){
6            int x = m[0],y = m[1],t = m[2];
7            timeMeetings.computeIfAbsent(t,k -> new ArrayList<>()).add(new int[]{x,y});
8        }
9
10        // Boolean Array to mark if a person knows the secret or not
11        boolean[] ks = new boolean[n];// ks -> knows Secret
12        ks[0] = true;
13        ks[fp] = true;
14
15        for(int t : timeMeetings.keySet()){
16            // For each person, save all the people whom he/she meets at time t
17            // Basically make an adjacency list for the graph formed by meetings at time t only
18
19            Map<Integer,List<Integer>> meetList = new HashMap<>();
20            for (int[] m : timeMeetings.get(t)) {
21                int x = m[0],y = m[1];
22                meetList.computeIfAbsent(x,k -> new ArrayList<>()).add(y);
23                meetList.computeIfAbsent(y,k -> new ArrayList<>()).add(x);
24            }
25
26            // Set to avoid redundancy
27            Set<Integer> start = new HashSet<>();
28                for (int[] m : timeMeetings.get(t)) {
29                    int x = m[0], y = m[1];
30                    if (ks[x]) start.add(x);
31                    if (ks[y]) start.add(y);
32                }
33
34            // BFS
35            Queue<Integer> q = new LinkedList<>(start);
36            while(!q.isEmpty()){
37                int person = q.poll();
38                for(int nextPerson : meetList.getOrDefault(person,new ArrayList<>())){
39                    if(!ks[nextPerson]){
40                        ks[nextPerson] = true;
41                        q.offer(nextPerson);
42                    }
43                }
44            }
45        }
46        
47        List<Integer> res = new ArrayList<>();
48        for(int i=0;i<n;i++){
49            if(ks[i]) res.add(i);
50        }
51        return res;
52    }
53}