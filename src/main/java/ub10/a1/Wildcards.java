package ub10.a1;

import ub09.a1bis6.Folge;
import ub09.a1bis6.FolgemitEVL;

public class Wildcards{

    public static void main(String[] args){
    // Generische Folgen
    Folge<Object> objectFolge = new FolgemitEVL<>();
    Folge<Number> numberFolge = new FolgemitEVL<>();
    Folge<Integer> intFolge = new FolgemitEVL<>();;
    // Upperbounded
    Folge<? extends Object> extendedobjectFolge = intFolge;
    Folge<? extends Number> extendednumberFolge = intFolge;
    Folge<? extends Integer> extendedintFolge =intFolge;
    extendedobjectFolge = numberFolge;
    extendednumberFolge = numberFolge;
   // extendedintFolge = numberFolge; //weil Integer Spezieller ist bzw. Number ist Genereller
    extendedobjectFolge = objectFolge;
    //extendednumberFolge = objectFolge; weil Number Spezieller ist bzw. Object ist genereller
    //extendedintFolge = objectFolge; //weil Integer Spezieller ist bzw. Object ist genereller
    // Lower-bounded
    Folge<? super Object> superobjectFolge = objectFolge;
    Folge<? super Number> supernumberFolge = objectFolge;
    Folge<? super Integer> superintFolge = objectFolge;
    //superobjectFolge = numberFolge;
    supernumberFolge = numberFolge;

    superintFolge = numberFolge;
   // superobjectFolge = intFolge;
    //supernumberFolge = intFolge;
    superintFolge = intFolge;
    Folge<?> aFolge = objectFolge;
    aFolge = numberFolge;
    aFolge = intFolge;
    }
}