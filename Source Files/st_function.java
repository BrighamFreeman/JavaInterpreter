import java.util.*;
class st_function {
  String name;
  String command;
  String end;
  String value;
  String val;
  public st_function(String a,String b,String c,String ret,ArrayList<intvar> storage,ArrayList<stringvar> stringStorage){
    name = a;
    command = b;
    end = c;
    value = ret;
    //System.out.println(value);
    String flurmp = "";
    for(int i = 0; i < storage.size();i++){
      if(value.equals(storage.get(i).getName())){
        value = "" + storage.get(i).returnNum();
      }  
    }
    for(int i = 0; i < stringStorage.size();i++){
      if(value.equals(stringStorage.get(i).getName())){
        value = stringStorage.get(i).getString();
      }
    }
    if(!value.equals("input"))
      val = value;
  }

  public void run(ArrayList<intvar> storage,ArrayList<stringvar> stringStorage){
    
    if(command.equals("print")){
      String toPrint = end;
      for(int i = 0; i < storage.size();i++){
        if(storage.get(i).getName().equals(end)){
          toPrint = "" + storage.get(i).returnNum();
        }
      }
      
      for(int i = 0; i < stringStorage.size();i++){
        if(stringStorage.get(i).getName().equals(end)){
          toPrint = "" + stringStorage.get(i).getString();
        }
      }
      if(end.equals("input")){
        Scanner m = new Scanner(System.in);
        String flurmp = m.nextLine();
        toPrint = flurmp;
      }
      System.out.println(toPrint);
    }
    
    for(int i = 0; i < stringStorage.size();i++){
      String y = "";
      if(stringStorage.get(i).getName().equals(command)){
        if(end.equals("input")){
          Scanner s = new Scanner(System.in);
          String newInt = s.nextLine();
          y = newInt;
        } else {
          y = end;
        }
        
        stringStorage.get(i).update(0,y,stringStorage.get(i).getName());
      }
    }
  }
  public String getName(){
    return name;
  }
  
  public String returnN(ArrayList<stringvar> stringStorage){
    if(value.equals("input")){
      Scanner meem = new Scanner(System.in);
      String z = meem.nextLine();
      val = z;
    }
    for(int i = 0; i < stringStorage.size(); i++){
      if(stringStorage.get(i).getName().equals(value)){
        val = stringStorage.get(i).getString();
      }
    }
    return val;
  }
}