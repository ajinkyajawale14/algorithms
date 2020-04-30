
	private static String ss(String s, int[][] shift) {
		// TODO Auto-generated method stub
		//  0 -> left 
		//  1 -> right
	
		char[] c=s.toCharArray();
		ArrayList<Character>pq=new ArrayList<Character>(s.length());
		for (char d : c) {
			pq.add(d);
		}
//		System.out.println(pq);
		int l=0;
		int r=0;
		int lcount=0;
		int rcount=0;
		for(int i=0;i<shift.length;i++) {
		
			
			//shift[i][0] = 0 -> leftshift || shift[i][0]= 1 -> rightshift
			if(shift[i][0]==0) {
				l++;
				lcount+=shift[i][1];
			}
			else { // shift[i][0]= 1 -> rightshift
				r++;
				rcount+=shift[i][1];
			}
		}
		int finalcount=0;
		int flag=0; //left
		if(lcount>rcount) {
			finalcount=lcount-rcount;
			flag=0;
		}else{
			finalcount=rcount-lcount;
			flag=1;
		}
		if(flag==0) { //left
			for(int i=0;i<finalcount;i++) {
				char tch=pq.remove(0);
				pq.add(tch);
			}
			
		}
		else { //right
			for(int i=0;i<finalcount;i++) {
				char tch=pq.remove(pq.size()-1);
				pq.add(0,tch);
			}
		}
		StringBuilder d=new StringBuilder(pq.size());
		for (Character ch : pq) {
			d.append(ch);
		}
		return d.toString();
	}
