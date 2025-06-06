class intvar {
    int num;
    String myString;
    private String name;
    
    public intvar(int a,String c, String b){
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
        myString = c;
    }
    public String getName(){
        return name;
    }
    public void assignName(String i){
        name = i;
    }
    
} 