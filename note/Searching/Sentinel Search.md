### Prerequisite & Assumption

*There're neither assumptions nor prerequisites*
### Axioms

Given that our value doesn't match with any element beside the last element, and one match must exist within our array, we can assert that the last element must be the matching case. 
### Implementation

Based on [[#Axioms]], we can instantly assign our last element to be the value. In this case, we need not a comparative check whether we're at the end of the array or not. For example, check out this for-loop:

```
for (int i = 0; i < n; i++){
	//Do something
}
```

With sentinel search, we immediately remove the higher-bound checking, which result in something like this:

```
for (int i = 0; i++){
	//Do something
}
```

Why we can do that you may ask. It's due to the incredible feature of sentinel search. Again, based on the [[#Axioms]], we may inferred that since our value is at the end of the , we have to reach it at some point, so there's no need to check if we are at the end of the array or not, because it's simply redundant. 

In the worst case, the element we're looking for is actually at the end of the array. We have to check for it separately. Let's call the **last** element of the array L, and our value V. First, we need to make sure our L actually V, or it's just coincidentally being placed at that position but in fact, doesn't match at all.

```
if (L == V)
	return L // Or its index

return -1
```

And now, if it's not coincidental, then we'll have the index of the last element as a match. Else, -1 will be returned.

```Java
public int search(ArrayList<Integer> array, Integer value) {  
    int arrayLength = array.size();  
  
    int memoLastElem = array.getLast();  
  
    //The iterator  
    int i = 0;  
  
    while (i < arrayLength && !Objects.equals(array.get(i), value))  
        i++;  
  
    if (i < arrayLength - 1){  
        //Means that the value existed within the array  
        return i;  
    }else{  
        //Check the last elem just in case the last one matches and place it back  
        array.set(arrayLength - 1, memoLastElem);  
  
        if (memoLastElem == value){  
            return arrayLength - 1;  
        }  
  
        return -1;  
    }  
}
```

#### Note

Check out [[Binary Search#Note]]