public class DHArrayList <E> implements BareBonesArrayList<E>{

  //Data
  private int size; 		//How many elements are there
  private int capacity;	//How big is the array?
  private E[] myArray;	//Reference to the actual array,, yet to be created
  private static final int INITIAL_CAPACITY = 10;	//Default capacity

  //Constructors
  //Default Constructor
  public DHArrayList() {
    //This constructor creates an array with default capacity
    this.capacity = this .INITIAL_CAPACITY;
    this.size =0; 	//When the array is created, it's empty
    myArray = (E[]) new Object[this.capacity];  //This creates the actual array

  }
  //Overloaded Constructor
  public DHArrayList(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    myArray = (E[]) new Object[this.capacity];
  }


  @Override
  public void add(E a) {
    //This method will add an element to the end of the list
    //First need to check if there is space to add an element
    if(this.size<this.capacity) {
      //This means, there is space
      //The index where we can insert the data is given by size
      myArray[this.size] = a;		//This is the actual data insertion
      this.size++;					//Update the number of elements in the array

    }
    else{
      //There is no space in my array
      //We need to call reallocate() method
      System.out.println("Sorry, no more space available!  Calling rellocate!");
      //Now call realocate()
      this.reallocate();
      this.add(a);		//Once reallocate provides the space, call add again

    }

  }

  private void reallocate() {
    //Double capacity
    //Copy over the elements
    //Change the reference
    this.capacity *= 2;
    E[] temp = (E[]) new Object[this.capacity];
    //Copy elements over
    for(int i = 0; i<myArray.length;i++) {
      temp[i] = myArray[i];

    }
    //Update reference
    this.myArray = temp;


  }
  @Override
  public void add(E a, int index) {

  }

  @Override
  public E remove(int index) {

    return null;
  }

  @Override
  public E get(int index) {

    return null;
  }

  @Override
  public void set(E a, int index) {


  }

  @Override
  public int getSize() {

    return 0;
  }

  @Override
  public int indexOf(E a) {

    return 0;
  }
  public String toString() {
    //This method returns the content of the array in a String
    String s = " ";
    //We iterate over the array, add all elements to the string
    for(int i = 0; i<this.size;i++) {	//iterate till size, number of elements
      s = s + myArray[i]+ ", ";		//", " for formatting
    }
    return s;
  }

}

