
public class Problem4 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] scores = {
				{8,9},
				{4,6},
				{7,3}
		};
		int[] toplam = new int[3];
		
		for (int i=0;i< scores.length;i++) {
			toplam[i] = scores[i][0] + scores[i][1];
		}
		
		for (int i = 0; i < 3; i++) {
            System.out.println("Player " + (i + 1) + ": " + scores[i][0] + " and " + scores[i][1] + " = Total: " + toplam[i]);
        }
		
		int max=0;
		for (int i = 1;i<toplam.length;i++) {
			if (toplam[i]>toplam[max]) {
				max = i;
			}
		}
		System.out.println("Winner is Player " + (max + 1) );
	}

}
