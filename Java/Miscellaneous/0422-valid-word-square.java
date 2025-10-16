class Solution {
    public boolean validWordSquare(List<String> words) {
        if (words == null || words.isEmpty()) return true;

        int rows = words.size();
        for (int h = 0; h <= rows-1; h++) {
            String horizontal = words.get(h);
            StringBuilder vertical = new StringBuilder();
            for (int v = 0; v <= rows-1; v++) {
                String w = words.get(v);
                if (w.length()-1 >= h) {
                    vertical.append(w.charAt(h));
                }
            }
            if (!horizontal.equals(vertical.toString())) return false;
        }
        return true;
    }
}