
class Printer {
	public static void main(String[] args){
		PrinterA a = new PrinterA();
		a.printInfo("TEST CONTENT");
		a.printDefault1("9999999999999999");

		PrinterB b = new PrinterB();
		b.printInfo("TEST CONTENT");

		PrinterC c = new PrinterC();
		c.printInfo("TEST CONTENT");


		a.printDefault();
		b.printDefault();
		c.printDefault();

		a.printDefault1();
		b.printDefault1();
		c.printDefault1();
	}
}

/*
*
----PrinterA write some content---->TEST CONTENT
print some default content ******9999999999999999
----PrinterB write some content---->TEST CONTENT
----PrinterC write some content---->TEST CONTENT
print some default content
print some default content
print some default content
print some default content ******
print some default content ******
print some default content ******
*/



class PrinterA implements printInfo {
	
	public void printInfo(String content){
		System.out.println("----PrinterA write some content---->"+content);
	}
}

class PrinterB implements printInfo {
	
	public void printInfo(String content){
		System.out.println("----PrinterB write some content---->"+content);
	}
}

class PrinterC implements printInfo {
	
	public void printInfo(String content){
		System.out.println("----PrinterC write some content---->"+content);
	}
}

/**
 * 
 * 结论：
 * 1 接口中可以又多个默认方法，
 * 2 默认方法可以重载
 * 
 */
