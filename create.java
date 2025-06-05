import java.util.*;
import java.io.*;

/*

           Notes
================================================
    Make Stable release for dekstop interpreter
    Add functions to script command

*/







//function code 






    

class create { //main code class

  ArrayList<intvar> storage = new ArrayList<intvar>();
  ArrayList<stringvar> stringStorage = new ArrayList<stringvar>();
  ArrayList<intARvar> arrayStorage = new ArrayList<intARvar>();
  ArrayList<in_function> fStorage = new ArrayList<in_function>();
  ArrayList<stringARvar> aStringStorage = new ArrayList<stringARvar>();
  ArrayList<st_function> sStorage = new ArrayList<st_function>();
  
  public boolean isInteger(String a){
    boolean isValidInteger = false;
    //include try statement to avoid crashing if data is incorrect type
    try
    {
      Integer.parseInt(a);
 
      // s is a valid integer
 
      isValidInteger = true;
    }
    catch (NumberFormatException ex)
    {
      // s is not an integer
    }
 
    return isValidInteger;
  }

  

  public String help(String a){ //help function
    /*

    ABOUT: This function prints the help window to explain different commands and structures
    */
    String retValue = "";
    switch(a){
      case "if":
        retValue = " if <conditional1> [=/</>] <conditional2> | <command> : <value>;\n if (<expression>) [=/</>] [expression] | <command> : <value>;";
        break;
        
      case "credits":
        retValue = " Programmed by Brigham Freeman. Version 1.0 - August 1st, 2020";
        break;
      case "int":
        retValue = " int <variable name> = <integer value>;\n If you set the value to 'input' the value will be set to whatever you input next";
        break;
      case "print":
        retValue = " print <anything you want printed>; \n If you write a variable name, the printed value will be defaulted to the value it holds.";
        break;
      case "text":
        retValue = " text <variable name> = <string value>;\n If you set the value to 'input' the value will be whatever is inputted next";
        break;
      case "text[]":
        retValue = " text[] <variable name> = (<value1>,<value2>,...);";
        break;
      case "div":
        retValue = " div <variable name / int>/<variable name / int> -<variable name>\n if there is no variable under that name, a new one will be created with that name";
        break;
      case "add":
        retValue = " add <variable name / int>+<variable name / int> - <variable name>\n If there is no variable under that name, a new one will be created with that name";
        break;
      case "mul":
        retValue = " mul <variable name / int>*<variable name / int> - <variable name>\n If there is no variable under that name, a new one will be created with that name";
        break;
      case "sub":
        retValue = " sub <variable name / int>-<variable name / int> - <variable name>\n If there is no variable under that name, a new one will be created with that name";
        break;
      case "function":
        retValue = " function(type) <name> = <command> : <value> | <return value>;";
        break;
      case "int[]":
        retValue = " int[] <name> = (<content>);";
        break;
      case "script":
    retValue = " script <script name>;\n You don't need to include the '.cas' extension at the end.";
    break;
    
    case "log":
        retValue = " log <variable name> ~<filename>,<boolean>; \n The boolean value specifies if being appended. If a file under specified name doesn't exist, it will be created.";
        break;
    }
    return ("########HELP########\n" + "Correct Syntax:\n" + retValue + "\n####################");

  }
  //logic loop
  public void logic(String com, String finish,ArrayList<intvar> storage,ArrayList<stringvar> stringStorage,ArrayList<intARvar> arrayStorage,ArrayList<in_function> fStorage,ArrayList<st_function> sStorage){
    if(com.equals("print")){
      String toPrint = finish;
      for(int i = 0; i < storage.size();i++){
        if(storage.get(i).getName().equals(finish)){
          toPrint = "" + storage.get(i).returnNum();
        }
      }
      for(int i = 0; i < stringStorage.size();i++){
        if(stringStorage.get(i).getName().equals(finish)){
          toPrint = stringStorage.get(i).getString();
        }
      }
      System.out.println(toPrint);
    } //check if variable is being reset or changed
    //================================================
    
    if(com.contains("%")){
        String arrayName = finish.substring(0,finish.indexOf("%"));
        String content = finish.substring(finish.indexOf("%")+1, finish.length());
        int position = Integer.parseInt(content);
        String fart;
        for(int i = 0; i < arrayStorage.size(); i++){
            if(arrayStorage.get(i).getName().equals(arrayName)){
                
            }
        }
    }

    //mafematical operations
    if(com.equals("div")){
      String num1 = finish.substring(0,finish.indexOf("/"));
      String num2 = finish.substring(finish.indexOf("/")+1,finish.indexOf("~")-1);
      String var = finish.substring(finish.indexOf("~")+1,finish.length());
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
      if(finish.contains("{")){
        String arrayName = finish.substring(finish.indexOf("~")+1,finish.indexOf("{"));
        String position = finish.substring(finish.indexOf("{")+1,finish.indexOf("}"));
        int pos = 0;
        boolean posDef = false;
        for(int i = 0; i < arrayStorage.size();i++){
          if(arrayStorage.get(i).getName().equals(arrayName)){
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(position)){
                pos = storage.get(j).returnNum();
                posDef = true;
              }
            }
            if(!posDef){
              pos = Integer.parseInt(position);
            }
            //arrayStorage.get(i).update
          }
        }
      }
      if(!isDef){
        if(!print)
          storage.add(new intvar(total,"",var));
        else
          System.out.println(total);
      }
    }

    if(com.equals("mul")){
      String num1 = finish.substring(0,finish.indexOf("*"));
      String num2 = finish.substring(finish.indexOf("*")+1,finish.indexOf("~")-1);
      String var = finish.substring(finish.indexOf("~")+1,finish.length());
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
      boolean print = false;
      if(var.equals("disp"))
        print = true;
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
      if(finish.contains("{")){
        String arrayName = finish.substring(finish.indexOf("~")+1,finish.indexOf("{"));
        String position = finish.substring(finish.indexOf("{")+1,finish.indexOf("}"));
        int pos = 0;
        boolean posDef = false;
        for(int i = 0; i < arrayStorage.size();i++){
          if(arrayStorage.get(i).getName().equals(arrayName)){
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(position)){
                pos = storage.get(j).returnNum();
                posDef = true;
              }
            }
            if(!posDef){
              pos = Integer.parseInt(position);
            }
            //arrayStorage.get(i).update
          }
        }
      }
      if(!isDef){
        if(print)
          System.out.println(total);
        else 
          storage.add(new intvar(total,"",var));
      }
    }
    
    if(com.equals("sub")){
      String num1 = finish.substring(0,finish.indexOf("-"));
      String num2 = finish.substring(finish.indexOf("-")+1,finish.indexOf("~")-1);
      String var = finish.substring(finish.indexOf("~")+1);
      boolean print = false;
      if(var.equals("disp"))
        print = true;
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
      if(finish.contains("{")){
        String arrayName = finish.substring(finish.indexOf("~")+1,finish.indexOf("{"));
        String position = finish.substring(finish.indexOf("{")+1,finish.indexOf("}"));
        int pos = 0;
        boolean posDef = false;
        for(int i = 0; i < arrayStorage.size();i++){
          if(arrayStorage.get(i).getName().equals(arrayName)){
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(position)){
                pos = storage.get(j).returnNum();
                posDef = true;
              }
            }
            if(!posDef){
              pos = Integer.parseInt(position);
            }
            //arrayStorage.get(i).update
          }
        }
      }
      if(!isDef){
        if(print)
          System.out.println(total);
        else
          storage.add(new intvar(total,"",var));
      }
    }

    if(com.equals("add")){
      String num1 = finish.substring(0,finish.indexOf("+"));
      String num2 = finish.substring(finish.indexOf("+")+1,finish.indexOf("~")-1);
      String var = finish.substring(finish.indexOf("~")+1);
      boolean print = false;
      if(var.equals("disp"))
        print = true;
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
      if(finish.contains("{")){
        String arrayName = finish.substring(finish.indexOf("~")+1,finish.indexOf("{"));
        String position = finish.substring(finish.indexOf("{")+1,finish.indexOf("}"));
        int pos = 0;
        boolean posDef = false;
        for(int i = 0; i < arrayStorage.size();i++){
          if(arrayStorage.get(i).getName().equals(arrayName)){
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(position)){
                pos = storage.get(j).returnNum();
                posDef = true;
              }
            }
            if(!posDef){
              pos = Integer.parseInt(position);
            }
            //arrayStorage.get(i).update
          }
        }
      }
      if(!isDef){
        if(print)
          System.out.println(total);
        else
          storage.add(new intvar(total,"",var));
      }
    }

    for(int i = 0; i < storage.size();i++){
      if(storage.get(i).getName().equals(com)){
        if(finish.equals("input")){
          Scanner c = new Scanner(System.in);
          finish = c.nextLine();
        }
        int newVar = Integer.parseInt(finish);
        storage.get(i).update(newVar,"",storage.get(i).getName());
      }
    }
    if(!isInteger(finish)){
      if(finish.equals("input")){
        Scanner in = new Scanner(System.in);
        String f = in.nextLine();
        finish = f;
      }
    }
    for(int i = 0; i < stringStorage.size();i++){
      if(stringStorage.get(i).getName().equals(com)){
        stringStorage.get(i).update(0,finish,stringStorage.get(i).getName());
      }
    }
    //perform other things
    for(int i = 0; i < fStorage.size();i++){
      if(com.equals(fStorage.get(i).getName())){
        fStorage.get(i).run(storage,stringStorage);
        if(finish.equals("disp")){
          System.out.println("" + fStorage.get(i).returnN(storage));
        } else {
          for(int k = 0; k < storage.size(); k++){
            if(storage.get(k).getName().equals("finish")){
              storage.get(k).update(fStorage.get(i).returnN(storage),"",storage.get(k).getName());
            }
          }
        }
      }
    }
    for(int i = 0; i < sStorage.size();i++){
      if(com.equals(sStorage.get(i).getName())){
        sStorage.get(i).run(storage,stringStorage);
        if(finish.equals("disp")){
          System.out.println("" + sStorage.get(i).returnN(stringStorage));
        } else {
          for(int k = 0; k < stringStorage.size(); k++){
            if(stringStorage.get(k).getName().equals("finish")){
              //stringStorage.get(k).update(sStorage.get(i).returnN(stringStorage),"",stringStorage.get(k).getName());
            }
          }
        }
      }
    }
  }
    //================================================
    
  
  public create(){   //constructor
    
    System.out.println("ENTER COMMAND");
    System.out.println("For more info type 'help'");
    while(true){
      Scanner in = new Scanner(System.in);
      String command = in.next();
      String next = in.nextLine();

      if(command.equals("cls")){
        System.out.print("\033[H\033[2J");  

        System.out.flush();
      }
      
      if(command.equals("quit")){
          System.exit(0);
           }
      // code to read code from a script file
      if(command.equals("script")){
          try {
              String f = next.substring(1,next.indexOf(";")) + ".cas";

              File file = new File(f);
              Scanner s = new Scanner(file);
              while(s.hasNextLine()){
                  String scriptCommand = s.next();
                  String scriptNext = s.nextLine();
                  if(scriptCommand.equals("int")){
                    
                    String n = scriptNext.substring(scriptNext.indexOf("int") + 2, scriptNext.indexOf("=")-1);
                    String num = scriptNext.substring((scriptNext.indexOf("=")) + 2,scriptNext.indexOf(";"));
                    if(num.equals("input")){
                      Scanner me  = new Scanner(System.in);
                      num = me.nextLine();
                    }
                    if(num.contains("random")){
                      String high = scriptNext.substring(scriptNext.indexOf("(")+1,scriptNext.indexOf(")"));
                      for(int i = 0; i < storage.size();i++){
                        if(storage.get(i).getName().equals(high)){
                          high = "" + storage.get(i).returnNum();
                        }
                      }
                      for(int i = 0; i < arrayStorage.size();i++){
                        if(arrayStorage.get(i).getName().equals(high)){
                          high = "" + arrayStorage.get(i).getSize(); 
                        }
                      }
                      for(int i = 0; i < aStringStorage.size();i++){
                        if(aStringStorage.get(i).getName().equals(high)){
                          high = "" + aStringStorage.get(i).getSize(); 
                        }
                      } 
                      Random r = new Random();
                      int max = Integer.parseInt(high);
                      int rand = r.nextInt(max);
                      num = "" + rand;
                    }
                    for(int i = 0; i < fStorage.size();i++){
                      if(fStorage.get(i).getName().equals(num)){
                        fStorage.get(i).run(storage,stringStorage);
                        num = "" + fStorage.get(i).returnN(storage);
                      }
                    }
                    int g = Integer.parseInt(num);                
                    storage.add(new intvar(g,"",n));
                  }
                  if(scriptCommand.equals("int[]")){
          
                      String name = scriptNext.substring(1,scriptNext.indexOf("=")-1);
                      String conn = scriptNext.substring(scriptNext.indexOf("(")+1,scriptNext.indexOf(")"));
                      String[] content = conn.split(",");
                      int[] x = new int[content.length];
                      for(int i = 0; i < x.length; i++){
                        x[i] = Integer.parseInt(content[i]);
                      }
                      //System.out.println(name);
                      arrayStorage.add(new intARvar(name,x));
                      
                  }
                  if(scriptCommand.equals("text[]")){
          
                      String name = scriptNext.substring(1,scriptNext.indexOf("=")-1);
                      String conn = scriptNext.substring(scriptNext.indexOf("(")+1,scriptNext.indexOf(")"));
                      String[] content = conn.split(",");
                      
                      
                      //System.out.println(name);
                      aStringStorage.add(new stringARvar(name,content));
                      
                  }
                  if(scriptCommand.equals("text")){
                    
                    String n = scriptNext.substring(scriptNext.indexOf("string") + 2, scriptNext.indexOf("=")-1);
                    String str = scriptNext.substring((scriptNext.indexOf("=")) + 2,scriptNext.indexOf(";"));
                    if(str.equals("input")){
                      Scanner me  = new Scanner(System.in);
                      str = me.nextLine();
                    }
            
                    for(int i = 0; i < sStorage.size();i++){
                      if(sStorage.get(i).getName().equals(str)){
                        sStorage.get(i).run(storage,stringStorage);
                        str = sStorage.get(i).returnN(stringStorage);
                      }
                    }
                                 
                    stringStorage.add(new stringvar(0,str,n));
            
                  }
                  if(scriptCommand.equals("print")){
                    String toPrint;
                    if(!scriptNext.contains("[")){
                      toPrint = scriptNext.substring(1,scriptNext.indexOf(";"));
                    } else {
                      toPrint = scriptNext.substring(1,scriptNext.indexOf("["));
                    }
                    for(int i = 0; i < storage.size(); i++){
                      if(storage.get(i).getName().equals(toPrint))
                      {
                       toPrint = "" + storage.get(i).returnNum();
                      }
                    }
                    for(int i = 0; i < stringStorage.size(); i++){
                      if(stringStorage.get(i).getName().equals(toPrint))
                      {
                       toPrint = stringStorage.get(i).getString();
                      }
                    }
                    for(int i = 0; i < arrayStorage.size();i++){
                      if(arrayStorage.get(i).getName().equals(toPrint))
                      {
                        String size = scriptNext.substring(scriptNext.indexOf("[")+1,scriptNext.indexOf("]"));
                        for(int j = 0; j < storage.size();j++){
                          if(storage.get(j).getName().equals(size)){
                            size = "" + storage.get(j).returnNum();
                          }
                        }
                        int iSize = Integer.parseInt(size);
                        toPrint = "" + arrayStorage.get(i).getN(iSize);
                      }
                    }
                    for(int i = 0; i < aStringStorage.size();i++){
                      if(aStringStorage.get(i).getName().equals(toPrint))
                      {
                        String size = scriptNext.substring(scriptNext.indexOf("[")+1,scriptNext.indexOf("]"));
                        for(int j = 0; j < storage.size();j++){
                          if(storage.get(j).getName().equals(size)){
                            size = "" + storage.get(j).returnNum();
                          }
                        }
                        int iSize = Integer.parseInt(size);
                        toPrint = "" + aStringStorage.get(i).getN(iSize);
                      }
                    }
                    System.out.println(toPrint);
                    /*for(int i = 0; i < stringStorage.size(); i++){
                      if(stringStorage.get(i).getName().equals(toPrint))
                      {
                        System.out.println(storage.get(i).getString());
                      }
                    }*/
                    
                    //logic codes
                    
                  }
                  if(storage.size() > 0){
                    for(int i = 0; i < storage.size();i++){
                      if(scriptCommand.equals(storage.get(i).getName())){
                        String spantzz = scriptNext.substring(scriptNext.indexOf("=")+2,scriptNext.indexOf(";"));
                        boolean def = false;
                        int val = 0;
                        if(isInteger(spantzz)){
                          val = Integer.parseInt(spantzz);
                          def = true;
                        } else {
                          if(f.equals("input")){
                            Scanner spoop = new Scanner(System.in);
                            String x = spoop.nextLine();
                            val = Integer.parseInt(x);
                            def = true;
                          } else {System.out.println("Error: Bad Formatting");}
                        }
                        if(def){storage.get(i).update(val,"",storage.get(i).getName());}
                      }
                    }
                  }
                  if(scriptCommand.equals("if")){ //DO NOT TOUCH ANYTHING INSIDE THIS LOOP!
                String operator = "";
                String conditional1 = ""; //define vars
                String conditional2 = "";
                if(scriptNext.contains("(")){
                        String op1 = "";
                        String n = scriptNext.substring(1,scriptNext.indexOf(")")+1);
                        if(n.contains("+")){
                        op1 = "+";
              } else {
                if(n.contains("-")){
                  op1 = "-";
                } else {
                  if(n.contains("/")){
                    op1 = "/";
                  } else {
                    op1 = "*";
                  }
                }
              }
              String first = n.substring(n.indexOf("(")+1,n.indexOf(op1));
              String second = n.substring(n.indexOf(op1)+1,n.indexOf(")"));
              
              int iFirst = 0;
              boolean isInt1 = false;
              boolean isInt2 = false;
              int iSecond = 0;
              for(int i = 0; i < storage.size(); i++){
                if(first.equals(storage.get(i).getName())){
                  iFirst = storage.get(i).returnNum();
                  isInt1 = true;
                }
                if(second.equals(storage.get(i).getName())){
                  iSecond = storage.get(i).returnNum();
                  isInt2 = true;
                }
              }
              if(isInteger(first)){
                iFirst = Integer.parseInt(first);
                isInt1 = true;
              }
              if(isInteger(second)){
                iSecond = Integer.parseInt(second);
                isInt2 = true;
              }
              //logic
              if(isInt1 && isInt2){
                int totes = 1;
                switch (op1){
                  case "+":
                    totes = iFirst + iSecond;
                    break;
                  case "-":
                    totes = iFirst - iSecond;
                    break;
                  case "/":
                    totes = iFirst / iSecond;
                    break;
                  case "*":
                    totes = iFirst * iSecond;
                    break;

                }
                conditional1 = "" + totes;
              }
              if(scriptNext.contains("=")){
                operator = "=";
              } else {
                if(scriptNext.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
          } else {
            if(scriptNext.contains("=")){
                operator = "=";
              } else {
                if(scriptNext.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
            conditional1 = scriptNext.substring(1,scriptNext.indexOf(operator)-1);
            conditional2 = scriptNext.substring(scriptNext.indexOf(operator)+2,scriptNext.indexOf("|")-1);
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional1)){
                conditional1 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional2)){
                conditional2 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional1)){
                conditional1 = "" + stringStorage.get(i).getString();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional2)){
                conditional2 = "" + stringStorage.get(i).returnNum();
              }
            }
            //check for var input
          }
         
        

              if(scriptNext.contains("[")){
                String op2 = "";
                String dib = scriptNext.substring(scriptNext.indexOf(operator)+1,scriptNext.indexOf(";"));
                if(dib.contains("+")){
                  op2 = "+";
                } else {
                  if(dib.contains("-")){
                    op2 = "-";
                  } else {
                    if(dib.contains("/")){
                      op2 = "/";
                    } else {
                      op2 = "*";
                    }
                  }
                }
                String foop = dib.substring(dib.indexOf("[")+1,dib.indexOf(op2));
                String soop = dib.substring(dib.indexOf(op2)+1,dib.indexOf("]"));
                int iF = 0;
                boolean i1 = false;
                boolean i2 = false;
                int iS = 0;
                for(int i = 0; i < storage.size(); i++){
                  if(foop.equals(storage.get(i).getName())){
                    iF = storage.get(i).returnNum();
                    i1 = true;
                  }
                  if(soop.equals(storage.get(i).getName())){
                    iS = storage.get(i).returnNum();
                    i2 = true;
                  }
                }
                if(isInteger(foop)){
                  iF = Integer.parseInt(foop);
                  i1 = true;
                }
                if(isInteger(soop)){
                  iS = Integer.parseInt(soop);
                  i2 = true;
                }
                //logic
                if(i1 && i2){
                  int glorp = 0;
                  switch(op2){
                    case "+":
                      glorp = iF + iS;
                      break;
                    case "-":
                      glorp = iF - iS;
                      break;
                    case "/":
                      glorp = iF / iS;
                      break;
                    case "*":
                      glorp = iF * iS;
                      break;

                  }
                  
                  conditional2 = "" + glorp;
                }                
                
              } else {
                conditional2 = scriptNext.substring(scriptNext.indexOf(operator)+2,scriptNext.indexOf("|")-1);
                for(int i = 0; i < storage.size();i++){
                  if(storage.get(i).getName().equals(conditional2)){
                  conditional2 = "" + storage.get(i).returnNum();
                  }
                 }
                 for(int i = 0; i < stringStorage.size();i++){
                    if(stringStorage.get(i).getName().equals(conditional2)){
                    conditional2 = stringStorage.get(i).getString();
                  }
                }
              }
              String divided = scriptNext.substring(scriptNext.indexOf("|"),scriptNext.indexOf(";"));
              String com = scriptNext.substring(scriptNext.indexOf("|")+2,scriptNext.indexOf(":")-1);
              String finish = "";
              if(divided.contains("{")){
                int retrieve = 0;
                String x = divided.substring(divided.indexOf(":")+2,divided.indexOf("{"));
                String y = divided.substring(divided.indexOf("{")+1,divided.indexOf("}"));
                if(isInteger(y)){
                  retrieve = Integer.parseInt(y);
                }
                for(int i = 0; i < arrayStorage.size();i++){
                  if(arrayStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        retrieve = storage.get(j).returnNum();
                      }
                    }
                    
                    finish = "" + arrayStorage.get(i).getN(retrieve);
                  }
                  
                }
                for(int i = 0; i < aStringStorage.size();i++){
                  if(aStringStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        finish = "" + storage.get(j).returnNum();
                      }
                    }
                    
                    finish = aStringStorage.get(i).getN(retrieve);
                  }
                  
                }
                
              } else {
                if(divided.contains("#")){
                  
                  
                } else {
                  finish = scriptNext.substring(scriptNext.indexOf(":")+2,scriptNext.indexOf(";"));
                }
              }
             
              
              
              if(isInteger(conditional1) && isInteger(conditional2)){
                int int1 = Integer.parseInt(conditional1);
                int int2 = Integer.parseInt(conditional2);
                if(operator.equals("=")){
                  if(int1 == int2){
                    logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                  }
                } else {
                  if(operator.equals(">")){
                    if(int1 > int2){
                      logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                    }
                  } else {
                    if(int1 < int2){
                      logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                    }
                  }
                
                 
           
            

              }
            } else {
              if(conditional1.equals(conditional2)){
                logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
              }
            }
       }
       if(scriptCommand.equals("for")){ //DO NOT TOUCH ANYTHING INSIDE THIS LOOP!
          String operator = "";
          String conditional1 = ""; //define vars
          String conditional2 = "";
          if(scriptNext.contains("(")){
              String op1 = "";
              String n = scriptNext.substring(1,scriptNext.indexOf(")")+1);
              if(n.contains("+")){
                op1 = "+";
              } else {
                if(n.contains("-")){
                  op1 = "-";
                } else {
                  if(n.contains("/")){
                    op1 = "/";
                  } else {
                    op1 = "*";
                  }
                }
              }
              String first = n.substring(n.indexOf("(")+1,n.indexOf(op1));
              String second = n.substring(n.indexOf(op1)+1,n.indexOf(")"));
              
              int iFirst = 0;
              boolean isInt1 = false;
              boolean isInt2 = false;
              int iSecond = 0;
              for(int i = 0; i < storage.size(); i++){
                if(first.equals(storage.get(i).getName())){
                  iFirst = storage.get(i).returnNum();
                  isInt1 = true;
                }
                if(second.equals(storage.get(i).getName())){
                  iSecond = storage.get(i).returnNum();
                  isInt2 = true;
                }
              }
              if(isInteger(first)){
                iFirst = Integer.parseInt(first);
                isInt1 = true;
              }
              if(isInteger(second)){
                iSecond = Integer.parseInt(second);
                isInt2 = true;
              }
              //logic
              if(isInt1 && isInt2){
                int totes = 1;
                switch (op1){
                  case "+":
                    totes = iFirst + iSecond;
                    break;
                  case "-":
                    totes = iFirst - iSecond;
                    break;
                  case "/":
                    totes = iFirst / iSecond;
                    break;
                  case "*":
                    totes = iFirst * iSecond;
                    break;

                }
                conditional1 = "" + totes;
              }
              if(scriptNext.contains("=")){
                operator = "=";
              } else {
                if(scriptNext.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
          } else {
            if(scriptNext.contains("=")){
                operator = "=";
              } else {
                if(scriptNext.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
            conditional1 = scriptNext.substring(1,scriptNext.indexOf(operator)-1);
            conditional2 = scriptNext.substring(scriptNext.indexOf(operator)+2,scriptNext.indexOf("|")-1);
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional1)){
                conditional1 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional2)){
                conditional2 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional1)){
                conditional1 = "" + stringStorage.get(i).getString();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional2)){
                conditional2 = "" + stringStorage.get(i).returnNum();
              }
            }
            //check for var input
          }
         
        

              if(scriptNext.contains("[")){
                String op2 = "";
                String dib = scriptNext.substring(scriptNext.indexOf(operator)+1,scriptNext.indexOf(";"));
                if(dib.contains("+")){
                  op2 = "+";
                } else {
                  if(dib.contains("-")){
                    op2 = "-";
                  } else {
                    if(dib.contains("/")){
                      op2 = "/";
                    } else {
                      op2 = "*";
                    }
                  }
                }
                String foop = dib.substring(dib.indexOf("[")+1,dib.indexOf(op2));
                String soop = dib.substring(dib.indexOf(op2)+1,dib.indexOf("]"));
                int iF = 0;
                boolean i1 = false;
                boolean i2 = false;
                int iS = 0;
                for(int i = 0; i < storage.size(); i++){
                  if(foop.equals(storage.get(i).getName())){
                    iF = storage.get(i).returnNum();
                    i1 = true;
                  }
                  if(soop.equals(storage.get(i).getName())){
                    iS = storage.get(i).returnNum();
                    i2 = true;
                  }
                }
                if(isInteger(foop)){
                  iF = Integer.parseInt(foop);
                  i1 = true;
                }
                if(isInteger(soop)){
                  iS = Integer.parseInt(soop);
                  i2 = true;
                }
                //logic
                if(i1 && i2){
                  int glorp = 0;
                  switch(op2){
                    case "+":
                      glorp = iF + iS;
                      break;
                    case "-":
                      glorp = iF - iS;
                      break;
                    case "/":
                      glorp = iF / iS;
                      break;
                    case "*":
                      glorp = iF * iS;
                      break;

                  }
                  
                  conditional2 = "" + glorp;
                }                
                
              } else {
                conditional2 = scriptNext.substring(scriptNext.indexOf(operator)+2,scriptNext.indexOf("|")-1);
                for(int i = 0; i < storage.size();i++){
                  if(storage.get(i).getName().equals(conditional2)){
                  conditional2 = "" + storage.get(i).returnNum();
                  }
                 }
                 for(int i = 0; i < stringStorage.size();i++){
                    if(stringStorage.get(i).getName().equals(conditional2)){
                    conditional2 = stringStorage.get(i).getString();
                  }
                }
              }
              String divided = scriptNext.substring(scriptNext.indexOf("|"),scriptNext.indexOf(";"));
              String com = scriptNext.substring(scriptNext.indexOf("|")+2,scriptNext.indexOf(":")-1);
              String finish = "";
              if(divided.contains("{")){
                int retrieve = 0;
                String x = divided.substring(divided.indexOf(":")+2,divided.indexOf("{"));
                String y = divided.substring(divided.indexOf("{")+1,divided.indexOf("}"));
                if(isInteger(y)){
                  retrieve = Integer.parseInt(y);
                }
                for(int i = 0; i < arrayStorage.size();i++){
                  if(arrayStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        retrieve = storage.get(j).returnNum();
                      }
                    }
                    
                    finish = "" + arrayStorage.get(i).getN(retrieve);
                  }
                  
                }
                for(int i = 0; i < aStringStorage.size();i++){
                  if(aStringStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        finish = "" + storage.get(j).returnNum();
                      }
                    }
                    
                    finish = aStringStorage.get(i).getN(retrieve);
                  }
                  
                }
                
              } else {
                finish = scriptNext.substring(scriptNext.indexOf(":")+2,scriptNext.indexOf(";"));
              }
             
              
              
              if(isInteger(conditional1) && isInteger(conditional2)){
                int int1 = Integer.parseInt(conditional1);
                int int2 = Integer.parseInt(conditional2);
                for(int i = int1; i < int2; i++){
                  logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                }
            } else {
              if(conditional1.equals(conditional2)){
                logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
              }
            }
       }
              }
              
            } catch (IOException e){
                System.out.println("couldn't find script");
            }
      }

      if(command.equals("help") || command.equals("help;")){
        if(next.contains("-")){
          //correct syntax - help -<command>;
          String com = next.substring(next.indexOf("-")+1,next.indexOf(";"));
          System.out.println(help(com));
          } else {
            System.out.println("##########HELP##########");
            String[] cooms = {"int","int[]","if","text","text[]","print","div","add","mul","sub","function","script","log"};
            System.out.println("Type help -<command name>; to see more");
            for(int i = 0; i < cooms.length; i++){
              System.out.println(cooms[i]);
            }
            System.out.println("#######################");
          }
        }
      

      if(command.equals("int")){
                    
        String n = next.substring(next.indexOf("int") + 2, next.indexOf("=")-1);
        String num = next.substring((next.indexOf("=")) + 2,next.indexOf(";"));
        if(num.equals("input")){
          Scanner me  = new Scanner(System.in);
          num = me.nextLine();
        }
        if(num.contains("random")){
          String high = next.substring(next.indexOf("(")+1,next.indexOf(")"));
          for(int i = 0; i < storage.size();i++){
            if(storage.get(i).getName().equals(high)){
              high = "" + storage.get(i).returnNum();
            }
          }
          for(int i = 0; i < arrayStorage.size();i++){
            if(arrayStorage.get(i).getName().equals(high)){
              high = "" + arrayStorage.get(i).getSize(); 
            }
          }
          for(int i = 0; i < aStringStorage.size();i++){
            if(aStringStorage.get(i).getName().equals(high)){
              high = "" + aStringStorage.get(i).getSize(); 
            }
          } 
          Random r = new Random();
          int max = Integer.parseInt(high);
          int rand = r.nextInt(max);
          num = "" + rand;
        }
        for(int i = 0; i < fStorage.size();i++){
          if(fStorage.get(i).getName().equals(num)){
            fStorage.get(i).run(storage,stringStorage);
            num = "" + fStorage.get(i).returnN(storage);
          }
        }
        int g = Integer.parseInt(num);                
        storage.add(new intvar(g,"",n));
      }

      if(command.equals("int[]")){
          
          String name = next.substring(1,next.indexOf("=")-1);
          String conn = next.substring(next.indexOf("(")+1,next.indexOf(")"));
          String[] content = conn.split(",");
          int[] x = new int[content.length];
          for(int i = 0; i < x.length; i++){
            x[i] = Integer.parseInt(content[i]);
          }
          //System.out.println(name);
          arrayStorage.add(new intARvar(name,x));
          
      }

      if(command.equals("text[]")){
          
          String name = next.substring(1,next.indexOf("=")-1);
          String conn = next.substring(next.indexOf("(")+1,next.indexOf(")"));
          String[] content = conn.split(",");
          
          
          //System.out.println(name);
          aStringStorage.add(new stringARvar(name,content));
          
      }
      
      if(command.equals("text")){
                    
        String n = next.substring(next.indexOf("string") + 2, next.indexOf("=")-1);
        String str = next.substring((next.indexOf("=")) + 2,next.indexOf(";"));
        if(str.equals("input")){
          Scanner me  = new Scanner(System.in);
          str = me.nextLine();
        }

        for(int i = 0; i < sStorage.size();i++){
          if(sStorage.get(i).getName().equals(str)){
            sStorage.get(i).run(storage,stringStorage);
            str = sStorage.get(i).returnN(stringStorage);
          }
        }
                     
        stringStorage.add(new stringvar(0,str,n));

      }
      
      if(command.equals("print")){
        String toPrint;
        if(!next.contains("[")){
          toPrint = next.substring(1,next.indexOf(";"));
        } else {
          toPrint = next.substring(1,next.indexOf("["));
        }
        for(int i = 0; i < storage.size(); i++){
          if(storage.get(i).getName().equals(toPrint))
          {
           toPrint = "" + storage.get(i).returnNum();
          }
        }
        for(int i = 0; i < stringStorage.size(); i++){
          if(stringStorage.get(i).getName().equals(toPrint))
          {
           toPrint = stringStorage.get(i).getString();
          }
        }
        for(int i = 0; i < arrayStorage.size();i++){
          if(arrayStorage.get(i).getName().equals(toPrint))
          {
            String size = next.substring(next.indexOf("[")+1,next.indexOf("]"));
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(size)){
                size = "" + storage.get(j).returnNum();
              }
            }
            int iSize = Integer.parseInt(size);
            toPrint = "" + arrayStorage.get(i).getN(iSize);
          }
        }
        for(int i = 0; i < aStringStorage.size();i++){
          if(aStringStorage.get(i).getName().equals(toPrint))
          {
            String size = next.substring(next.indexOf("[")+1,next.indexOf("]"));
            for(int j = 0; j < storage.size();j++){
              if(storage.get(j).getName().equals(size)){
                size = "" + storage.get(j).returnNum();
              }
            }
            int iSize = Integer.parseInt(size);
            toPrint = "" + aStringStorage.get(i).getN(iSize);
          }
        }
        System.out.println(toPrint);
        /*for(int i = 0; i < stringStorage.size(); i++){
          if(stringStorage.get(i).getName().equals(toPrint))
          {
            System.out.println(storage.get(i).getString());
          }
        }*/
        
        //logic codes
        
      }
      //check if command is defined
      if(storage.size() > 0){
        for(int i = 0; i < storage.size();i++){
          if(command.equals(storage.get(i).getName())){
            String f = next.substring(next.indexOf("=")+2,next.indexOf(";"));
            boolean def = false;
            int val = 0;
            if(isInteger(f)){
              val = Integer.parseInt(f);
              def = true;
            } else {
              if(f.equals("input")){
                Scanner s = new Scanner(System.in);
                String x = s.nextLine();
                val = Integer.parseInt(x);
                def = true;
              } else {System.out.println("Error: Bad Formatting");}
            }
            if(def){storage.get(i).update(val,"",storage.get(i).getName());}
          }
        }
      }

      //logical operations
      if(command.equals("if")){ //DO NOT TOUCH ANYTHING INSIDE THIS LOOP!
          String operator = "";
          String conditional1 = ""; //define vars
          String conditional2 = "";
          if(next.contains("(")){
              String op1 = "";
              String n = next.substring(1,next.indexOf(")")+1);
              if(n.contains("+")){
                op1 = "+";
              } else {
                if(n.contains("-")){
                  op1 = "-";
                } else {
                  if(n.contains("/")){
                    op1 = "/";
                  } else {
                    op1 = "*";
                  }
                }
              }
              String first = n.substring(n.indexOf("(")+1,n.indexOf(op1));
              String second = n.substring(n.indexOf(op1)+1,n.indexOf(")"));
              
              int iFirst = 0;
              boolean isInt1 = false;
              boolean isInt2 = false;
              int iSecond = 0;
              if(first.contains("%")){
                  String arrayName = first.substring(0,first.indexOf("%"));
                  String position = first.substring(first.indexOf("%")+1,first.length());  //check array value
                  for(int i = 0; i < arrayStorage.size(); i++){
                      if(arrayStorage.get(i).getName().equals(arrayName)){
                          int iposition = Integer.parseInt(position);
                          iFirst = arrayStorage.get(i).getN(iposition);
                          isInt1 = true;
                        }
                    }
                }
              for(int i = 0; i < storage.size(); i++){
                if(first.equals(storage.get(i).getName())){
                  iFirst = storage.get(i).returnNum();
                  isInt1 = true;
                }
                if(second.equals(storage.get(i).getName())){
                  iSecond = storage.get(i).returnNum();
                  isInt2 = true;
                }
              }
              if(isInteger(first)){
                iFirst = Integer.parseInt(first);
                isInt1 = true;
              }
              if(isInteger(second)){
                iSecond = Integer.parseInt(second);
                isInt2 = true;
              }
              //logic
              if(isInt1 && isInt2){
                int totes = 1;
                switch (op1){
                  case "+":
                    totes = iFirst + iSecond;
                    break;
                  case "-":
                    totes = iFirst - iSecond;
                    break;
                  case "/":
                    totes = iFirst / iSecond;
                    break;
                  case "*":
                    totes = iFirst * iSecond;
                    break;

                }
                conditional1 = "" + totes;
              }
              if(next.contains("=")){
                operator = "=";
              } else {
                if(next.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
          } else {
            if(next.contains("=")){
                operator = "=";
              } else {
                if(next.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
            conditional1 = next.substring(1,next.indexOf(operator)-1);
            conditional2 = next.substring(next.indexOf(operator)+2,next.indexOf("|")-1);
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional1)){
                conditional1 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional2)){
                conditional2 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional1)){
                conditional1 = "" + stringStorage.get(i).getString();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional2)){
                conditional2 = "" + stringStorage.get(i).returnNum();
              }
            }
            //check for var input
          }
         
        

              if(next.contains("[")){
                String op2 = "";
                String dib = next.substring(next.indexOf(operator)+1,next.indexOf(";"));
                if(dib.contains("+")){
                  op2 = "+";
                } else {
                  if(dib.contains("-")){
                    op2 = "-";
                  } else {
                    if(dib.contains("/")){
                      op2 = "/";
                    } else {
                      op2 = "*";
                    }
                  }
                }
                String f = dib.substring(dib.indexOf("[")+1,dib.indexOf(op2));
                String s = dib.substring(dib.indexOf(op2)+1,dib.indexOf("]"));
                int iF = 0;
                boolean i1 = false;
                boolean i2 = false;
                int iS = 0;
                for(int i = 0; i < storage.size(); i++){
                  if(f.equals(storage.get(i).getName())){
                    iF = storage.get(i).returnNum();
                    i1 = true;
                  }
                  if(s.equals(storage.get(i).getName())){
                    iS = storage.get(i).returnNum();
                    i2 = true;
                  }
                }
                if(isInteger(f)){
                  iF = Integer.parseInt(f);
                  i1 = true;
                }
                if(isInteger(s)){
                  iS = Integer.parseInt(s);
                  i2 = true;
                }
                //logic
                if(i1 && i2){
                  int glorp = 0;
                  switch(op2){
                    case "+":
                      glorp = iF + iS;
                      break;
                    case "-":
                      glorp = iF - iS;
                      break;
                    case "/":
                      glorp = iF / iS;
                      break;
                    case "*":
                      glorp = iF * iS;
                      break;

                  }
                  
                  conditional2 = "" + glorp;
                }                
                
              } else {
                conditional2 = next.substring(next.indexOf(operator)+2,next.indexOf("|")-1);
                for(int i = 0; i < storage.size();i++){
                  if(storage.get(i).getName().equals(conditional2)){
                  conditional2 = "" + storage.get(i).returnNum();
                  }
                 }
                 for(int i = 0; i < stringStorage.size();i++){
                    if(stringStorage.get(i).getName().equals(conditional2)){
                    conditional2 = stringStorage.get(i).getString();
                  }
                }
              }
              String divided = next.substring(next.indexOf("|"),next.indexOf(";"));
              String com = next.substring(next.indexOf("|")+2,next.indexOf(":")-1);
              String finish = "";
              if(divided.contains("{")){
                int retrieve = 0;
                String x = divided.substring(divided.indexOf(":")+2,divided.indexOf("{"));
                String y = divided.substring(divided.indexOf("{")+1,divided.indexOf("}"));
                if(isInteger(y)){
                  retrieve = Integer.parseInt(y);
                }
                for(int i = 0; i < arrayStorage.size();i++){
                  if(arrayStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        retrieve = storage.get(j).returnNum();
                      }
                    }
                    
                    finish = "" + arrayStorage.get(i).getN(retrieve);
                  }
                  
                }
                for(int i = 0; i < aStringStorage.size();i++){
                  if(aStringStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        finish = "" + storage.get(j).returnNum();
                      }
                    }
                    
                    finish = aStringStorage.get(i).getN(retrieve);
                  }
                  
                }
                
              } else {
                if(divided.contains("#")){
                  
                  
                } else {
                  finish = next.substring(next.indexOf(":")+2,next.indexOf(";"));
                }
              }
             
              if(conditional1.contains("%")){
                  String arrayName = next.substring(1,next.indexOf("%"));
                  String position = next.substring(next.indexOf("%")+1,next.indexOf("=")-1);  //check array value
                  
                  for(int i = 0; i < arrayStorage.size(); i++){
                      if(arrayStorage.get(i).getName().equals(arrayName)){
                          int iposition = Integer.parseInt(position);
                          conditional1 = "" + arrayStorage.get(i).getN(iposition);
                          
                        }
                    }
                }
                
                if(conditional2.contains("%")){
                  String arrayName = next.substring(next.indexOf("=") + 2,next.indexOf("%"));
                  String position = next.substring(next.indexOf("%")+1,next.indexOf("|")-1);  //check array value
                  //System.out.println(arrayName);
                  //System.out.println(position);
                  for(int i = 0; i < arrayStorage.size(); i++){
                      if(arrayStorage.get(i).getName().equals(arrayName)){
                          int iposition = Integer.parseInt(position);
                          conditional2 = "" + arrayStorage.get(i).getN(iposition);
                          
                        }
                    }
                }
              
              if(isInteger(conditional1) && isInteger(conditional2)){
                int int1 = Integer.parseInt(conditional1);
                int int2 = Integer.parseInt(conditional2);
                if(operator.equals("=")){
                  if(int1 == int2){
                    logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                  }
                } else {
                  if(operator.equals(">")){
                    if(int1 > int2){
                      logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                    }
                  } else {
                    if(int1 < int2){
                      logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                    }
                  }
                
                 
           
            

              }
            } else {
              if(conditional1.equals(conditional2)){
                logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
              }
            }
       } // end of if comparison - NEVER TOUCH AGAIN !!!!!11!!!!1!!        

       if(command.equals("for")){ //DO NOT TOUCH ANYTHING INSIDE THIS LOOP!
          String operator = "";
          String conditional1 = ""; //define vars
          String conditional2 = "";
          if(next.contains("(")){
              String op1 = "";
              String n = next.substring(1,next.indexOf(")")+1);
              if(n.contains("+")){
                op1 = "+";
              } else {
                if(n.contains("-")){
                  op1 = "-";
                } else {
                  if(n.contains("/")){
                    op1 = "/";
                  } else {
                    op1 = "*";
                  }
                }
              }
              String first = n.substring(n.indexOf("(")+1,n.indexOf(op1));
              String second = n.substring(n.indexOf(op1)+1,n.indexOf(")"));
              
              int iFirst = 0;
              boolean isInt1 = false;
              boolean isInt2 = false;
              int iSecond = 0;
              for(int i = 0; i < storage.size(); i++){
                if(first.equals(storage.get(i).getName())){
                  iFirst = storage.get(i).returnNum();
                  isInt1 = true;
                }
                if(second.equals(storage.get(i).getName())){
                  iSecond = storage.get(i).returnNum();
                  isInt2 = true;
                }
              }
              if(isInteger(first)){
                iFirst = Integer.parseInt(first);
                isInt1 = true;
              }
              if(isInteger(second)){
                iSecond = Integer.parseInt(second);
                isInt2 = true;
              }
              //logic
              if(isInt1 && isInt2){
                int totes = 1;
                switch (op1){
                  case "+":
                    totes = iFirst + iSecond;
                    break;
                  case "-":
                    totes = iFirst - iSecond;
                    break;
                  case "/":
                    totes = iFirst / iSecond;
                    break;
                  case "*":
                    totes = iFirst * iSecond;
                    break;

                }
                conditional1 = "" + totes;
              }
              if(next.contains("=")){
                operator = "=";
              } else {
                if(next.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
          } else {
            if(next.contains("=")){
                operator = "=";
              } else {
                if(next.contains("<")){
                  operator = "<";
                } else {
                  operator = ">";
                }
              }
            conditional1 = next.substring(1,next.indexOf(operator)-1);
            conditional2 = next.substring(next.indexOf(operator)+2,next.indexOf("|")-1);
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional1)){
                conditional1 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < storage.size();i++){
              if(storage.get(i).getName().equals(conditional2)){
                conditional2 = "" + storage.get(i).returnNum();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional1)){
                conditional1 = "" + stringStorage.get(i).getString();
              }
            }
            for(int i = 0; i < stringStorage.size();i++){
              if(stringStorage.get(i).getName().equals(conditional2)){
                conditional2 = "" + stringStorage.get(i).returnNum();
              }
            }
            //check for var input
          }
         
        

              if(next.contains("[")){
                String op2 = "";
                String dib = next.substring(next.indexOf(operator)+1,next.indexOf(";"));
                if(dib.contains("+")){
                  op2 = "+";
                } else {
                  if(dib.contains("-")){
                    op2 = "-";
                  } else {
                    if(dib.contains("/")){
                      op2 = "/";
                    } else {
                      op2 = "*";
                    }
                  }
                }
                String f = dib.substring(dib.indexOf("[")+1,dib.indexOf(op2));
                String s = dib.substring(dib.indexOf(op2)+1,dib.indexOf("]"));
                int iF = 0;
                boolean i1 = false;
                boolean i2 = false;
                int iS = 0;
                for(int i = 0; i < storage.size(); i++){
                  if(f.equals(storage.get(i).getName())){
                    iF = storage.get(i).returnNum();
                    i1 = true;
                  }
                  if(s.equals(storage.get(i).getName())){
                    iS = storage.get(i).returnNum();
                    i2 = true;
                  }
                }
                if(isInteger(f)){
                  iF = Integer.parseInt(f);
                  i1 = true;
                }
                if(isInteger(s)){
                  iS = Integer.parseInt(s);
                  i2 = true;
                }
                //logic
                if(i1 && i2){
                  int glorp = 0;
                  switch(op2){
                    case "+":
                      glorp = iF + iS;
                      break;
                    case "-":
                      glorp = iF - iS;
                      break;
                    case "/":
                      glorp = iF / iS;
                      break;
                    case "*":
                      glorp = iF * iS;
                      break;

                  }
                  
                  conditional2 = "" + glorp;
                }                
                
              } else {
                conditional2 = next.substring(next.indexOf(operator)+2,next.indexOf("|")-1);
                for(int i = 0; i < storage.size();i++){
                  if(storage.get(i).getName().equals(conditional2)){
                  conditional2 = "" + storage.get(i).returnNum();
                  }
                 }
                 for(int i = 0; i < stringStorage.size();i++){
                    if(stringStorage.get(i).getName().equals(conditional2)){
                    conditional2 = stringStorage.get(i).getString();
                  }
                }
              }
              String divided = next.substring(next.indexOf("|"),next.indexOf(";"));
              String com = next.substring(next.indexOf("|")+2,next.indexOf(":")-1);
              String finish = "";
              if(divided.contains("{")){
                int retrieve = 0;
                String x = divided.substring(divided.indexOf(":")+2,divided.indexOf("{"));
                String y = divided.substring(divided.indexOf("{")+1,divided.indexOf("}"));
                if(isInteger(y)){
                  retrieve = Integer.parseInt(y);
                }
                for(int i = 0; i < arrayStorage.size();i++){
                  if(arrayStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        retrieve = storage.get(j).returnNum();
                      }
                    }
                    
                    finish = "" + arrayStorage.get(i).getN(retrieve);
                  }
                  
                }
                for(int i = 0; i < aStringStorage.size();i++){
                  if(aStringStorage.get(i).getName().equals(x)){
                    for(int j = 0; j < storage.size();j++){
                      if(storage.get(j).getName().equals(y)){
                        finish = "" + storage.get(j).returnNum();
                      }
                    }
                    
                    finish = aStringStorage.get(i).getN(retrieve);
                  }
                  
                }
                
              } else {
                finish = next.substring(next.indexOf(":")+2,next.indexOf(";"));
              }
             
              
              
              if(isInteger(conditional1) && isInteger(conditional2)){
                int int1 = Integer.parseInt(conditional1);
                int int2 = Integer.parseInt(conditional2);
                for(int i = int1; i < int2; i++){
                  logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
                }
            } else {
              if(conditional1.equals(conditional2)){
                logic(com,finish,storage,stringStorage,arrayStorage,fStorage,sStorage);
              }
            }
       }
            
      
           
      
         // end if

      //function code block
      if(command.equals("function(int)")){
        String name = next.substring(1,next.indexOf("=")-1);
        String com = next.substring(next.indexOf("=")+2,next.indexOf(":")-1);
        String com2 = next.substring(next.indexOf(":")+2,next.indexOf("|")-1);
        String fin = next.substring(next.indexOf("|")+2,next.indexOf(";"));
        
        fStorage.add(new in_function(name,com,com2,fin,storage,stringStorage));
        
      }

      if(command.equals("function(string)")){
        String name = next.substring(1,next.indexOf("=")-1);
        String com = next.substring(next.indexOf("=")+2,next.indexOf(":")-1);
        String com2 = next.substring(next.indexOf(":")+2,next.indexOf("|")-1);
        String fin = next.substring(next.indexOf("|")+2,next.indexOf(";"));

        sStorage.add(new st_function(name,com,com2,fin,storage,stringStorage));
        
      }

    //log variables
    
    if(command.equals("log")){
        //log variables to .cas file - log <name> ~filename;
        try {
            String varLog = next.substring(1,next.indexOf("~")-1);
            String fileName = next.substring(next.indexOf("~")+1,next.indexOf(","));
            String app = next.substring(next.indexOf(",")+1,next.indexOf(";"));
            boolean append = false;
            if(app.equals("t") || app.equals("T") || app.equals("true")){
                append = true;
            }
            
            File mikeDaddy = new File(fileName + ".txt");
            FileWriter printer = new FileWriter(mikeDaddy, append);
            for(int i = 0; i < storage.size(); i++){
                if(varLog.equals(storage.get(i).getName())){
                    printer.write(storage.get(i).getName() + ": " + storage.get(i).returnNum() + "\n");
                    printer.close();
                }
            }
            for(int i = 0; i < stringStorage.size(); i++){
                if(varLog.equals(stringStorage.get(i).getName())){
                    printer.write(stringStorage.get(i).getName() + ": " + stringStorage.get(i).getString()+"\n");
                    printer.close();
                }
            }
        } catch (IOException e){
            System.out.println("error");
        }
    }
      
      //math ops
      if(command.equals("div")){
        String var1 = next.substring(1,next.indexOf("/"));
        int int1 = 0;
        int int2 = 0;
        String var2 = next.substring(next.indexOf("/")+1,next.indexOf("~")-1);
        String newVar = next.substring(next.indexOf("~")+1,next.indexOf(";"));
        //System.out.println(var1 + " " + var2 + " " + newVar);
        boolean print = false;
        if(newVar.equals("disp"))
          print = true;
        if(isInteger(var1)){
          int1 = Integer.parseInt(var1);
        }
        if(isInteger(var2)){
          int2 = Integer.parseInt(var2);
        }
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(var1)){
            int1 = storage.get(i).returnNum();
          }
          if(storage.get(i).getName().equals(var2)){
            int2 = storage.get(i).returnNum();
          }
        }     
        int total = int1/int2;
        boolean isDef = false;
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(newVar)){
            isDef = true;
            storage.get(i).update(total,"",storage.get(i).getName());
          }
        }
        if(!isDef){
          if(print)
            System.out.println(total);
          else
            storage.add(new intvar(total,"",newVar));
        }
      }

      if(command.equals("add")){

        String var1 = next.substring(1,next.indexOf("+"));
        int int1 = 0;
        int int2 = 0;
        String var2 = next.substring(next.indexOf("+")+1,next.indexOf("~")-1);
        String newVar = next.substring(next.indexOf("~")+1,next.indexOf(";"));
        boolean print = false;
        if(newVar.equals("disp"))
          print = true;
        
        //System.out.println(var1 + " " + var2 + " " + newVar);
        if(isInteger(var1)){
          int1 = Integer.parseInt(var1);
        }
        if(isInteger(var2)){
          int2 = Integer.parseInt(var2);
        }
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(var1)){
            int1 = storage.get(i).returnNum();
          }
          if(storage.get(i).getName().equals(var2)){
            int2 = storage.get(i).returnNum();
          }
        }    
        int total = int1+int2;
        boolean isDef = false;
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(newVar)){
            isDef = true;
            storage.get(i).update(total,"",storage.get(i).getName());
          }
        }
        if(!isDef){
          if(print)
            System.out.println(total);
          else
            storage.add(new intvar(total,"",newVar));
        }
      }

      if(command.equals("sub")){
        
        String var1 = next.substring(1,next.indexOf("-"));
        int int1 = 0;
        int int2 = 0;
        String var2 = next.substring(next.indexOf("-")+1,next.indexOf("~")-1);
        String newVar = next.substring(next.indexOf("~")+1,next.indexOf(";"));
        boolean print = false;
        if(newVar.equals("disp"))
          print = true;
        
        if(isInteger(var1)){
          int1 = Integer.parseInt(var1);
        }
        if(isInteger(var2)){
          int2 = Integer.parseInt(var2);
        }
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(var1)){
            int1 = storage.get(i).returnNum();
          }
          if(storage.get(i).getName().equals(var2)){
            int2 = storage.get(i).returnNum();
          }
        }    
        int total = int1-int2;
        boolean isDef = false;
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(newVar)){
            isDef = true;
            storage.get(i).update(total,"",storage.get(i).getName());
          }
        }
        if(!isDef){
          if(print)
            System.out.println(total);
          else
            storage.add(new intvar(total,"",newVar));
        }
      }

      if(command.equals("mul")){
        
        String var1 = next.substring(1,next.indexOf("*"));
        int int1 = 0;
        int int2 = 0;
        String var2 = next.substring(next.indexOf("*")+1,next.indexOf("~")-1);
        String newVar = next.substring(next.indexOf("~")+1,next.indexOf(";"));
        boolean print = false;
        if(newVar.equals("disp"))
          print = true;
        
        //System.out.println(var1 + " " + var2 + " " + newVar);
        if(isInteger(var1)){
          int1 = Integer.parseInt(var1);
        }
        if(isInteger(var2)){
          int2 = Integer.parseInt(var2);
        }
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(var1)){
            int1 = storage.get(i).returnNum();
          }
          if(storage.get(i).getName().equals(var2)){
            int2 = storage.get(i).returnNum();
          }
        }    
        int total = int1*int2;
        boolean isDef = false;
        for(int i = 0; i < storage.size();i++){
          if(storage.get(i).getName().equals(newVar)){
            isDef = true;
            storage.get(i).update(total,"",storage.get(i).getName());
          }
        }
        if(!isDef){
          if(print)
            System.out.println(total);
          else
            storage.add(new intvar(total,"",newVar));
        }
      }
      }
      
    //end of main script
    }
  }



