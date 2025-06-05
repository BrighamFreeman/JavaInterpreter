class stringARvar {
  String[] myArray;
  String name;
  int size;
  public stringARvar(String a,String[] b){ //base array variable code
    name = a;
    myArray = b;
    size = b.length;
  }
  public String getN(int i){
    return myArray[i];
  }
  public String getName(){
    return(name);
  }
  public int getSize(){
    return size;
  }
}