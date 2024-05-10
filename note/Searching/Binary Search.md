Binary search is an algorithm that works based on the idea of divide and conquer approach. 

### Prerequisite & Assumption

- The array must be sorted in ascending order
### Axioms

The fact that if a number A is larger than certain number B, it must be larger than all number smaller than B. Let's say **5** is larger than **4**, thus it must be larger than **3, 2 and 1**

### Implementation

There're two ways of implementing this algorithm, a recursive way and the iterative way. Both produce the same time and space complexity respectively. However, on a larger scale, the recursive approach falls short as it can't meet up with the volume of data due to stack overflow

The main idea is that we have two variables tracking the boundaries of each side of the array. Let's call it A and B. First, we find the median of the current array based on its boundaries using the following formula:

```
median = (A + B) / 2
```

then check whether our value is larger of smaller than the median

If our value > median, it indicates that our value must be larger than the other left half as well (based on [[#Axioms]]), so we just need to check the other right half, simply by shifting A upwards to mid + 1. And the other way applied as well, and we'll move B downwards to mid - 1

```
if (value > median):
	A = mid + 1
else if (value < median):
	B = mid - 1
else
	//Here, we already find our value!
	return median //Or its index if you want, here we are returnning its value
```

#### Recursively

```Java
private int search__recursion_impl(ArrayList<Integer> array, Integer value, int left, int right){  
    // Base case: If the left boundary exceeds the right boundary, the value is not found  
    if (left > right){  
        return -1;  
    }  
  
    // Calculate the middle index of the sub-array  
    int mid = (left + right) / 2;  
  
    // If the value is greater than the middle element, search the right half  
    if (value > array.get(mid)){  
        return search__recursion_impl(array, value, mid + 1, right);  
    }  
    // If the value is less than the middle element, search the left half  
    else if (value < array.get(mid)){  
        return search__recursion_impl(array, value, left, mid - 1);  
    }  
    // If the value is equal to the middle element, return its index  
    else{  
        return mid;  
    }  
}
```

As you can see, we recursively delve into the left or right half based on the branching if-else statement, and return its value upwards
#### Iteratively

```Java
private int search__iteration_impl(ArrayList<Integer> array, Integer value, int left, int right){  
    while (left < right){  
        int mid = (left + right) / 2;  
  
        // If the value is greater than the middle element, search the right half  
        if (value > array.get(mid)){  
            left = mid + 1;  
        }  
        // If the value is less than the middle element, search the left half  
        else if (value < array.get(mid)){  
            right = mid - 1;  
        }  
        // If the value is equal to the middle element, return its index  
        else{  
            return mid;  
        }  
    }  
  
    //If the value doesn't exist  
    return -1;  
}
```

Pretty similar. However, the noticeable different is that now we're utilizing a while-loop instead, preventing too much stack calling process which leads to stack overflow.

#### Note
##### Duplicate numbers
- In case of duplicate values, these searching algorithms will return the first, last or any occurrence of the value based on our implementation.