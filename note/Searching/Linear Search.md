A brute force approach for finding a value

### Prerequisite & Assumption

*There're neither assumptions nor prerequisites*

### Axioms

*There's no axiom applied. Comprehensible with common sense*
### Implementation

We simply iterate through the array, checking each element with our value to see if they match or not. If we find our match, we return the index (or value) of the element, else we continue until reaching the end of the array.

```Java
public int search(ArrayList<Integer> array, Integer value){  
    // Get the length of the array  
    int arrayLength = array.size();  
  
    // Iterate through the array elements  
    for (int i = 0; i < arrayLength; i++){  
        // Check if the current element is equal to the specified value  
        if (array.get(i).equals(value)){  
            // Return the index if found  
            return i;  
        }  
    }  
  
    // Return -1 if the value is not found  
    return -1;  
}
```

Self-explanatory.

#### Note
- Similarly to [[Binary Search#Duplicate numbers]], we can find the last occurrence by iterating backwards. Or any occurrence by using a counter mechanism that counts whether we find that number, and only return when our counter reaches a predefined threshold.