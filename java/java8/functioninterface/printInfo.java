interface printInfo {
	default void printDefault(){
		System.out.println("print some default content");
	}

	default void printDefault1(){
		System.out.println("print some default content ******");
	}

	default void printDefault1(String str){
		System.out.println("print some default content ******"+str);
	}


	void printInfo(String content);
}