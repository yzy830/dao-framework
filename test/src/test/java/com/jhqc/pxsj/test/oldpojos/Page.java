package com.jhqc.pxsj.test.oldpojos;

import java.util.List;

public class Page {
	
	public static final int DEFAULT_INDEX = 1;
	public static final int DEFAULT_SIZE = 20;
	
	private int index = Page.DEFAULT_INDEX;
	
	private int size = Page.DEFAULT_SIZE;
	
	public Page(){}
	public Page(int index,int size){
		this.index = index;
		this.size = size;
	}

	public String getLimitSql(){
		return " limit ?,? ";
	}
	
	public void addLimitParamsToList(List<Object> list){
			list.add((getIndex()-1)*getSize());
			list.add(getSize());
	}
	
	
    public int getIndex() {
    	if(index <= 0) setIndex(DEFAULT_INDEX);
    	return index;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public int getSize() {
    	if(size <= 0) setSize(DEFAULT_SIZE);
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    
    public int getOffset() {
        return (getIndex()-1)*getSize();
    }
}
