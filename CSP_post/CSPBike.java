import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CSPBike extends CSP {
	
	static Set<Object> varBik = new HashSet<Object>(Arrays.asList(new String[] {"black", "blue", "green", "red", "white"}));
	static Set<Object> varNam = new HashSet<Object>(Arrays.asList(new String[] {"Adrian", "Charles", "Henry", "Joel", "Richard"}));
	static Set<Object> varSan = new HashSet<Object>(Arrays.asList(new String[] {"bacon", "chicken", "cheese", "pepperoni", "tuna"}));
	static Set<Object> varJui = new HashSet<Object>(Arrays.asList(new String[] {"apple", "cranberry", "grapefruit", "orange", "pineapple"}));
    static Set<Object> varAge = new HashSet<Object>(Arrays.asList(new String[] {"12 years", "13 years", "14 years", "15 years", "16 years"}));
    static Set<Object> varSpo = new HashSet<Object>(Arrays.asList(new String[] {"baseball", "basketball", "hockey", "soccer", "swimming"}));
	
	public boolean isGood(Object X, Object Y, Object x, Object y) {
		//if X is not even mentioned in by the constraints, just return true
		//as nothing can be violated
		if(!C.containsKey(X))
			return true;
		
		//check to see if there is an arc between X and Y
		//if there isn't an arc, then no constraint, i.e. it is good
		if(!C.get(X).contains(Y))
			return true;
        
        if(X.equals("white") && Y.equals("15 years") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("white") && Y.equals("12 years") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("15 years") && Y.equals("12 years") && (Integer)x-(Integer)y>-2)
            return false;

        if(X.equals("Henry") && Y.equals("soccer") && (Integer)x-(Integer)y!=-1)
            return false;
        
        if(X.equals("grapefruit") && Y.equals("tuna") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("grapefruit") && Y.equals("pineapple") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("tuna") && Y.equals("pineapple") && (Integer)x-(Integer)y>-2)
            return false;

        if(X.equals("swimming") && Y.equals("baseball") && Math.abs((Integer)x-(Integer)y)!=1)
            return false;

        if(X.equals("pineapple") && Y.equals("14 years") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("pineapple") && Y.equals("orange") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("14 years") && Y.equals("orange") && (Integer)x-(Integer)y>-2)
            return false;   

        if(X.equals("hockey") && Y.equals("pepperoni") && (Integer)x!=(Integer)y)
            return false;   

        if(X.equals("white") && Y.equals("blue") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("white") && Y.equals("black") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("blue") && Y.equals("black") && (Integer)x-(Integer)y>-2)
            return false; 

        if(X.equals("Joel") && Y.equals("16 years") && Math.abs((Integer)x-(Integer)y)!=1)
            return false;

        if(X.equals("Adrian") && Y.equals("pepperoni") && (Integer)x-(Integer)y!=-1)
            return false;

        if(X.equals("12 years") && Y.equals("14 years") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("12 years") && Y.equals("16 years") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("14 years") && Y.equals("16 years") && (Integer)x-(Integer)y>-2)
            return false; 

        if(X.equals("bacon") && Y.equals("white") && (Integer)x-(Integer)y<1)
            return false;

        if(X.equals("16 years") && Y.equals("cheese") && (Integer)x!=(Integer)y)
            return false;  

        if(X.equals("white") && Y.equals("Richard") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("white") && Y.equals("red") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("Richard") && Y.equals("red") && (Integer)x-(Integer)y>-2)
            return false;    

        if(X.equals("baseball") && Y.equals("apple") && Math.abs((Integer)x-(Integer)y)!=1)
            return false;

        if(X.equals("Charles") && Y.equals("Richard") && (Integer)x-(Integer)y<1)
            return false;
        if(X.equals("Charles") && Y.equals("Adrian") && (Integer)x-(Integer)y>-1)
            return false;
        if(X.equals("Richard") && Y.equals("Adrian") && (Integer)x-(Integer)y>-2)
            return false;  

		
		//Uniqueness constraints
		
		if(varBik.contains(X) && varBik.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varNam.contains(X) && varNam.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varSan.contains(X) && varSan.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varJui.contains(X) && varJui.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		if(varAge.contains(X) && varAge.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;

        if(varSpo.contains(X) && varSpo.contains(Y) && !X.equals(Y) && x.equals(y))
			return false;
		
		return true;
	}
		
	public static void main(String[] args) throws Exception {
		CSPBike csp = new CSPBike();
		
		Integer[] dom = {1,2,3,4,5};
		
		for(Object X : varBik) 
			csp.addDomain(X, dom);
		
		for(Object X : varNam) 
			csp.addDomain(X, dom);
        
        for(Object X : varSan) 
			csp.addDomain(X, dom);

		for(Object X : varJui) 
			csp.addDomain(X, dom);
		
		for(Object X : varAge) 
            csp.addDomain(X, dom);
        for(Object X : varSpo) 
			csp.addDomain(X, dom);
		
		
		//unary constraints: just remove values from domains
		
		for(int i=1; i<=5; i++)
			if(i != 3)
				csp.D.get("baseball").remove(i);
				
		for(int i=1; i<=5; i++)
			if(i != 1 && i!=5)
				csp.D.get("tuna").remove(i);
        
        for(int i=1; i<=5; i++)
            if(i != 4)
                csp.D.get("pineapple").remove(i);
                
        for(int i=1; i<=5; i++)
            if(i != 3)
                csp.D.get("black").remove(i);	
                
        for(int i=1; i<=5; i++)
            if(i != 1 && i!=5)
                csp.D.get("green").remove(i);

        for(int i=1; i<=5; i++)
            if(i != 5)
                csp.D.get("13 years").remove(i);

        for(int i=1; i<=5; i++)
            if(i != 5)
                csp.D.get("hockey").remove(i);

		//binary constraints: add constraint arcs
		
        csp.addBidirectionalArc("white", "15 years");	
        csp.addBidirectionalArc("white", "12 years");
        csp.addBidirectionalArc("12 years", "15 years");	

        csp.addBidirectionalArc("Henry", "soccer");
        
        csp.addBidirectionalArc("grapefruit", "tuna");
        csp.addBidirectionalArc("grapefruit", "pineapple");
        csp.addBidirectionalArc("pineapple", "tuna");

        csp.addBidirectionalArc("swimming", "baseball");

        csp.addBidirectionalArc("pineapple", "14 years");
        csp.addBidirectionalArc("pineapple", "orange");
        csp.addBidirectionalArc("orange", "14 years");

        csp.addBidirectionalArc("hockey", "pepperoni");

        csp.addBidirectionalArc("white", "blue");
        csp.addBidirectionalArc("white", "black");
        csp.addBidirectionalArc("black", "blue");

        csp.addBidirectionalArc("Joel", "16 years");

        csp.addBidirectionalArc("Adrian", "pepperoni");

        csp.addBidirectionalArc("12 years", "14 years");
        csp.addBidirectionalArc("12 years", "16 years");
        csp.addBidirectionalArc("16 years", "14 years");

        csp.addBidirectionalArc("bacon", "white");

        csp.addBidirectionalArc("16 years", "cheese");

        csp.addBidirectionalArc("white", "Richard");
        csp.addBidirectionalArc("white", "red");
        csp.addBidirectionalArc("red", "Richard");

        csp.addBidirectionalArc("baseball", "apple");
		
        csp.addBidirectionalArc("Charles", "Richard");
        csp.addBidirectionalArc("Charles", "Adrian");
        csp.addBidirectionalArc("Adrian", "Richard");

		//Uniqueness constraints
		
		for(Object X : varBik)
			for(Object Y : varBik)
				csp.addBidirectionalArc(X,Y);
		
		for(Object X : varNam)
			for(Object Y : varNam)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varSan)
			for(Object Y : varSan)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varJui)
			for(Object Y : varJui)
				csp.addBidirectionalArc(X,Y);

		for(Object X : varAge)
			for(Object Y : varAge)
                csp.addBidirectionalArc(X,Y);
                
        for(Object X : varSpo)
            for(Object Y : varSpo)
                csp.addBidirectionalArc(X,Y);


		//Now let's search for solution 
		
		Search search = new Search(csp);
		System.out.println(search.BacktrackingSearch());
	}
}