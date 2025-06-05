class intARvar {
  int[] myArray;
  String name;
  int size;
  public intARvar(String a,int[] b){ //base array variable code
    name = a;
    myArray = b;
    size = b.length;
  }
  public int getN(int i){
    return myArray[i];
  }
  public String getName(){
    return(name);
  }
  public int getSize(){
    return size;
  }
}