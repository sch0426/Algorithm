import java.util.*;
import java.io.*;

public class Main {
	static class Person implements Comparable<Person>{
		int age;
		String name;
		
		public Person(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
	
		@Override
		public int compareTo(Person o) {
			return Integer.compare(this.age, o.age);
		}
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<Person>[] people = new ArrayList[201];
		for(int i = 0; i < people.length; i++) {
			people[i] = new ArrayList<>();
		}

		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			people[age].add(new Person(age, name));
		}
		for(int i = 1; i < people.length; i++) {
			Collections.sort(people[i]);;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < people.length; i++) {
			for(Person p : people[i]) {
				sb.append(p.age).append(" ").append(p.name).append("\n");
			}
		}
		System.out.println(sb);
	}

}
