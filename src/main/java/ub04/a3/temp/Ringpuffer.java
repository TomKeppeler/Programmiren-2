package ub04.a3.temp;

import java.util.Arrays;
import java.util.NoSuchElementException;
/*<!---------------------------
Name: Ringpuffer
File: Ringpuffer.java
-----------------------------
Author: Marek Seipel
Data:   20.5.2021, 22:16:59
---------------------------->*/
public class Ringpuffer<T> {
	
	Object[] list;
	int first;
	int size;
	
	public Ringpuffer(int capacity) {
		list = new Object[capacity];
		first = 0;
		size = 0;
	}
	
	public int size() {
		return size;
	}

	public int capacity(){
		return list.length;
	}
	
	@SuppressWarnings("unchecked")
	public T get(int pos) {
		if(/*pos >= size ||*/ pos < 0){
			throw new java.lang.IndexOutOfBoundsException();
		}	
		return (T) list[(first + pos)%size];
	}
	
	public void set(int pos, T e) {
		if(/*pos >= size ||*/ pos < 0)
			throw new java.lang.IndexOutOfBoundsException();
		list[(first + pos)%list.length] = e;
	}
	
	public void addFirst(T e) {
		if (size == list.length)
			throw new IndexOutOfBoundsException();
		if(size > 0)
			if(first == 0)
				first = list.length-1;
			else
				first--;
		list[first] = e;
		++size;
	}
	
	public void addLast(T e) {
		if (size == list.length)
			throw new IndexOutOfBoundsException();
		list[(first+size)%list.length] = e;
		++size;
	}
	
	@SuppressWarnings("unchecked")
	public T removeFirst() {
		if(size == 0)
			throw new NoSuchElementException();
		T out = (T) list[first];
		if(size == 1) {
			first = 0;
		}else {
			first = (first + 1) % list.length;
		}
		size--;
		return out;
	}
	
	@SuppressWarnings("unchecked")
	public T removeLast() {
		if(size == 0)
			throw new NoSuchElementException();
		T out = (T) list[(first + size - 1)%list.length];
		if(size == 1) {
			first = 0;
		}
		size--;
		return out;
	}


/*	public String toString() {
		return Arrays.toString(list);
	}*/


	public String toString(){
		String tz=" ";
		if(this.size == 0){
			return "Ring ist leer";
		}
		String out = "Ring{";
		for (int i = 0; i < this.size-1; i++) {
			out += get(i);
			out += tz;
		}
		out += get(this.size-1);//letztes Element ohne ","
		out += "}";
		return out;
	}

	public static void main(String[] args) {
		Ringpuffer<Integer> speicher = new Ringpuffer<>(10);
		System.out.println(speicher);
		for (int i = 0; i < 10; i++) {
			speicher.addLast(i);
		}
		speicher.set(15, 99);
		System.out.println(speicher);
	}
}
