/*
 * @lc app=leetcode.cn id=284 lang=java
 *
 * [284] 顶端迭代器
 */

// @lc code=start
// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

import java.util.Iterator;

class PeekingIterator implements Iterator<Integer> {

	Iterator<Integer> iterator;
	Integer next = null;
	boolean hasNext = true;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
		this.iterator = iterator;
		advance();
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return next;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int res = next;
		advance();
		return res;
	}
	
	@Override
	public boolean hasNext() {
	    return hasNext;
	}

	private void advance(){
		if(iterator.hasNext()){
			next = iterator.next();
		}else{
			hasNext = false;
		}
	}
}
// @lc code=end

