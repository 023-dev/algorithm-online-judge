import java.util.*;
import java.io.*;

public class Main {
    static class Meet {
        int start;
        int end;
        
        public Meet(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        Meet[] meets = new Meet[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meets[i] = new Meet(start, end);
        }
        
        Arrays.sort(meets, (o1, o2) -> {
            if(o1.end == o2.end) {return o1.start - o2.start;}
            return o1.end - o2.end;
        });
        
        int count = 0;
        int prev = 0;
        for (Meet meet : meets) {
            int start = meet.start;
            int end = meet.end;
            if (start >= prev) {
                count++;
                prev = end;
            }
        }
        
        System.out.println(count);
    }
}