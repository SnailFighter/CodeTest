import java.util.Optional;


public class OptionalTest{

	public static void main(String[] args) throws Exception{
		Pig pig = null;
		
		Pig pig1 = new Pig();
		pig1.setType("Helan pig");
		pig1.setWeight(200.14);
		try{

			Optional<Pig> pigOptional1 = Optional.of(pig1);
			if(pigOptional1==null){
				System.out.println("-------------------");
			}
			pigOptional1.ifPresent(p->System.out.println(p.getWeight()));

			// if now pig is null ,it will throw NullPointerException in running time
			
			Optional<Pig> pigOptionalnull = Optional.of(pig);  //here nullPointerException
			Pig pigEmpty = pigOptionalnull.orElse(new Pig());


			if(pigOptionalnull.isPresent()){
				System.out.println(pigOptionalnull.get().getWeight());
			}


		}catch(Exception e){
			e.printStackTrace();
		}
		
		Optional<Pig> pigOptional2 = Optional.ofNullable(pig);
		
		
		pigOptional2.ifPresent(value2->{
				System.out.println("pig----------->"+((Pig)pigOptional2.get()).getWeight());
			});
		
		Pig pig2 = pigOptional2.orElse(new Pig("Japanese Pig"));
		System.out.println("pig2-------------->"+pig2.toString());
		Optional<Pig> pigOptional3 = Optional.ofNullable(null);
		Optional<Pig> pigOptional4 = Optional.ofNullable(pig);
		
		pigOptional4.ifPresent(value4->{
			System.out.println(((Pig)pigOptional4.get()).getWeight());
			});
		
		Pig pig3 = pigOptional3.orElse(new Pig("USA Pig"));
		System.out.println("pig3----------------------->"+pig3.toString());
		
	}
	
}