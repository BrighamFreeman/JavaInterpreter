class stringvar {
    int num;
    String myString;
    private String name;
    
    public stringvar(int a,String c, String b){
        num = a;
        myString = c;
        name = b;
    }
    public int returnNum(){
        return num;
    }
    public void update(int a, String b, String c){
        num = a;
        assignName(c);
        myString = b;
    }
    public String getName(){
        return name;
    }
    public void assignName(String i){
        name = i;
    }
    public String getString(){
      return myString;
    }
} 