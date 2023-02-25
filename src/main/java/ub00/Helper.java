package ub00;

public class Helper {
        public static void move(IntegerBuffer source, IntegerBuffer sink){
            if (source.size() + sink.size() > sink.capacity()){
                throw new IllegalArgumentException();
            }
            while (0 < source.size()) {
                sink.push(source.pop());
            }   
    }
}
