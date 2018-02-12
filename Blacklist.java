import java.util.ArrayList;

class Blacklist{

	ArrayList <String> blkList = new ArrayList<String>();

	
	protected Blacklist(){
		this.blkList.add("fuck");
		this.blkList.add("motherfucker");
		this.blkList.add("motherfuck");
		this.blkList.add("ass");
		this.blkList.add("asshole");
		this.blkList.add("asswhole");
		this.blkList.add("shit");
		this.blkList.add("bullshit");
		this.blkList.add("prick");
		this.blkList.add("bitch");
		this.blkList.add("badword");

	}	

	public void add(String str){
		this.blkList.add(str);
	
	}

	public boolean containsBadWord(String str){
		String tmp = "";

		for(int i =0; i<str.length(); i++){
			if(str.charAt(i) != '\0' &&str.charAt(i) != ' ' && str.charAt(i) != '\n'){
				tmp += str.charAt(i);
				
			}
			if(i == (str.length()-1) || str.charAt(i) == ' '){
				for(String s: blkList){
					if(s.equals(tmp)){
						return true;
				   }
				}
			
			     tmp = "";	
			}
			

		}
				
		return false;

	}




}

