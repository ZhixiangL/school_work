package environment;

import java.util.Stack;
import java.util.HashMap;

public class StackHashMapEnvironment<V> implements Environment<String, V> {
    private Stack<HashMap<String, V>> stack;

    public StackHashMapEnvironment() {
        this.stack = new Stack<HashMap<String, V>>();
    }

    public void beginScope() {
        this.stack.push(new HashMap<String, V>());
    }

    public void endScope() {
        this.stack.pop();
    }

    public boolean inCurrentScope(K key) {
        return this.stack.peek().containsKey(key);
    }

    public void add(String key, V value) {
        this.stack.peek().put(key, value);
    }

    public V lookup(String key) {      
        return this.stack.peek().get(key);
    }
}
