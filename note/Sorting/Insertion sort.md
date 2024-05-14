The insertion sort is a sorting algorithm where the element will be compared backwards to be inserted in the right position, kinda like a deck of cards.

### Implementation

Assume that we're playing a game of cards. And you have been given 13 cards at the start of the round. Now you want to sort it in order to play it efficiently.

When sorting like this. We'll tend go from left to right, picking each card subsequently, and then compare it with all of the previous cards we traversed through. If we manage to find a card which its value is larger than our current card, we'll switch them.

And that's the rough idea of how insertion sort works.

Let's look at the implementation in an in-depth manner, we'll call **i** as our outermost loop iterator

```
for (int i = 1; i < arrayLength; i++){
	//Code here
}
```

Then let's call **value** our current value

```
int value = array[i];
```

Now, based on the analogy, we might want to compare our current **value** backwards

```
int j = i - 1;  
  
while (j >= 0 && value > array[j]){  
	array[j + 1] = array[j];  
    j--;  
}
```

**j** represent our temporary backwards iterator. We will keep traversing until either j reaches the first element, or we reach our destined slot. In this case, our card has found its position in the deck.

Also while going down, we need to shift the element upward to make spaces for our element, that's the role of the instruction at line 3.

And finally, we just simply set our value in place, or put our card in its position

```
array[j + 1] = value;
```

Java implementation:

```Java
public void sort(ArrayList<Integer> array, boolean isAsc) {  
    // We start from the second element, as the first one is assumed to be already
    // sorted  
    int arrayLength = array.size();  
  
    for (int i = 1; i < arrayLength; i++){  
        int value = array.get(i);  
  
        // The a copy of the current iterator so we can iterate backward and check 
        // those previous elements  
        int j = i - 1;  
  
        while (j >= 0 && compareFunction(array.get(j), value, isAsc)){  
            // compareFunction is an util function that checks whether this 
            // swapping operation should be performed  
            // check its source code at the base class (Sorting.java)         
            array.set(j + 1, array.get(j));  
            j--;  
        }  
  
        // The reason why we have to set value at j + 1 instead of j is that in the
        // previous while loop  
        // We end it with "j--", which means that our j will be offset 1 index 
        // behind our insert location        
        // So we need to add j + 1 to compensate for it        
        array.set(j + 1, value);  
    }  
}
```
