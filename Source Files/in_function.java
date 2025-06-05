import java.util.*;
class in_function {
  String name;
  String command;
  String end;
  String value;
  int val = 0;
  public in_function(String a,String b,String c,String ret,ArrayList<intvar> storage,ArrayList<stringvar> stringStorage){
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
    if(!value.equals("input"))
      val = Integer.parseInt(value);
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
    if(command.equals("div")){
      String num1 = end.substring(0,end.indexOf("/"));
      String num2 = end.substring(end.indexOf("/")+1,end.indexOf("~")-1);
      String var = end.substring(end.indexOf("~")+1,end.length());
      boolean print = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num1)){
          num1 = "" + storage.get(i).returnNum();
        } 
      }
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num2)){
          num2 = "" + storage.get(i).returnNum();
        } 
      }
      if(var.equals("disp")){
        print = true;
      }
      
      int i1 = Integer.parseInt(num1);
      int i2 = Integer.parseInt(num2);
      int total = i1/i2;
      boolean isDef = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(var)){
          storage.get(i).update(total,"",storage.get(i).getName());
          isDef = true;
        } 
      }
      
      if(!isDef){
        if(!print)
          storage.add(new intvar(total,"",var));
        else
          System.out.println(total);
      }
    }

    if(command.equals("mul")){
      String num1 = end.substring(0,end.indexOf("*"));
      String num2 = end.substring(end.indexOf("*")+1,end.indexOf("~")-1);
      String var = end.substring(end.indexOf("~")+1,end.length());
      boolean print = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num1)){
          num1 = "" + storage.get(i).returnNum();
        } 
      }
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num2)){
          num2 = "" + storage.get(i).returnNum();
        } 
      }
      if(var.equals("disp")){
        print = true;
      }
      
      int i1 = Integer.parseInt(num1);
      int i2 = Integer.parseInt(num2);
      int total = i1*i2;
      boolean isDef = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(var)){
          storage.get(i).update(total,"",storage.get(i).getName());
          isDef = true;
        } 
      }
      
      if(!isDef){
        if(!print)
          storage.add(new intvar(total,"",var));
        else
          System.out.println(total);
      }
    }

    if(command.equals("sub")){
      String num1 = end.substring(0,end.indexOf("-"));
      String num2 = end.substring(end.indexOf("-")+1,end.indexOf("~")-1);
      String var = end.substring(end.indexOf("~")+1,end.length());
      boolean print = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num1)){
          num1 = "" + storage.get(i).returnNum();
        } 
      }
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num2)){
          num2 = "" + storage.get(i).returnNum();
        } 
      }
      if(var.equals("disp")){
        print = true;
      }
      
      int i1 = Integer.parseInt(num1);
      int i2 = Integer.parseInt(num2);
      int total = i1-i2;
      boolean isDef = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(var)){
          storage.get(i).update(total,"",storage.get(i).getName());
          isDef = true;
        } 
      }
      
      if(!isDef){
        if(!print)
          storage.add(new intvar(total,"",var));
        else
          System.out.println(total);
      }
    }

    if(command.equals("add")){
      String num1 = end.substring(0,end.indexOf("+"));
      String num2 = end.substring(end.indexOf("+")+1,end.indexOf("~")-1);
      String var = end.substring(end.indexOf("~")+1,end.length());
      boolean print = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num1)){
          num1 = "" + storage.get(i).returnNum();
        } 
      }
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(num2)){
          num2 = "" + storage.get(i).returnNum();
        } 
      }
      if(var.equals("disp")){
        print = true;
      }
      
      int i1 = Integer.parseInt(num1);
      int i2 = Integer.parseInt(num2);
      int total = i1+i2;
      boolean isDef = false;
      for(int i = 0; i < storage.size(); i++){
        if(storage.get(i).getName().equals(var)){
          storage.get(i).update(total,"",storage.get(i).getName());
          isDef = true;
        } 
      }
      
      if(!isDef){
        if(!print)
          storage.add(new intvar(total,"",var));
        else
          System.out.println(total);
      }
    }
    
    for(int i = 0; i < storage.size();i++){
      int y = 0;
      if(storage.get(i).getName().equals(command)){
        if(end.equals("input")){
          Scanner s = new Scanner(System.in);
          String newInt = s.nextLine();
          y = Integer.parseInt(newInt);
        } else {
          y = Integer.parseInt(end);
        }
        
        storage.get(i).update(y,"",storage.get(i).getName());
      }
    }
  }
  public String getName(){
    return name;
  }
  
  public int returnN(ArrayList<intvar> storage){
    if(value.equals("input")){
      Scanner meem = new Scanner(System.in);
      String z = meem.nextLine();
      val = Integer.parseInt(z);
    }
    for(int i = 0; i < storage.size(); i++){
      if(storage.get(i).getName().equals(value)){
        val = storage.get(i).returnNum();
      }
    }
    return val;
  }
}