import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class LockingSpaceState {
	static String lock(String name,
					Map<String, String> status)
	{
		if ("lock".equals(status.get(name))
			|| "fail".equals(status.get(name))) {
			return "false";
		}
		else {
			status.put(name, "lock");
			return "true";
		}
	}

	static String unlock(String name,
						Map<String, String> status)
	{
		if ("lock".equals(status.get(name))) {
			status.put(name, "unlock");
			return "true";
		}
		else {
			return "false";
		}
	}

	static String upgrade(String name,
						Map<String, String> status,
						List<String> nodes)
	{
		int ind = nodes.indexOf(name) + 1;
		int c1 = ind * 2;
		int c2 = ind * 2 + 1;
		if (c1 < nodes.size() && c2 < nodes.size()) {
			if ("lock".equals(status.get(nodes.get(c1 - 1)))
				&& "lock".equals(
					status.get(nodes.get(c2 - 1)))) {
				status.put(nodes.get(c1 - 1), "unlock");
				status.put(nodes.get(c2 - 1), "unlock");
				status.put(name, "lock");
				return "true";
			}
			else {
				return "false";
			}
		}
		return "false";
	}

	static Map<String, String>
	precompute(List<String> nodes, List<String> queries)
	{
		List<String> d = new ArrayList<>();
		for (String query : queries) {
			String[] parts = query.split(" ");
			d.add(parts[1]);
			d.add(parts[0]);
		}
		Map<String, String> status = new HashMap<>();
		for (int j = 0; j < d.size() - 1; j += 2) {
			status.put(d.get(j), "unlock");
		}
		return status;
	}

	static String operation(String name, int code,
							Map<String, String> status,
							List<String> nodes)
	{
		String result = "false";
		switch (code) {
		case 1:
			result = lock(name, status);
			break;
		case 2:
			result = unlock(name, status);
			break;
		case 3:
			result = upgrade(name, status, nodes);
			break;
		}
		return result;
	}

	public static void main(String[] args)
	{
		int n = 7;
		int m = 2;
		int qs = 5;

		List<String> nodes = new ArrayList<>();
		nodes.add("World");
		nodes.add("Asia");
		nodes.add("Africa");
		nodes.add("China");
		nodes.add("India");
		nodes.add("SouthAfrica");
		nodes.add("Egypt");

		List<String> queries = new ArrayList<>();
		queries.add("1 China 9");
		queries.add("1 India 9");
		queries.add("3 Asia 9");
		queries.add("2 India 9");
		queries.add("2 Asia 9");

		// Precomputation
		Map<String, String> status
			= precompute(nodes, queries);

		// Function Call
		List<String> d = new ArrayList<>();
		for (String query : queries) {
			String[] parts = query.split(" ");
			d.add(parts[1]);
			d.add(parts[0]);
		}
		for (int j = 0; j < d.size() - 1; j += 2) {
			System.out.print(
				operation(d.get(j),
						Integer.parseInt(d.get(j + 1)),
						status, nodes)
				+ " ");
		}
	}
}

