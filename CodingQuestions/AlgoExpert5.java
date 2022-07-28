package CodingQuestions;// This file is initialized with a code version of this
// question's sample test case. Feel free to add, edit,
// or remove test cases in this file as you see fit!

import java.util.*;

class ProgramTest {

    public static void main(String[] args) {
        TestCase1();

    }
    public static HashMap<Character, Program.OrgChart> getOrgCharts() {
        var orgCharts = new HashMap<Character, Program.OrgChart>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
            orgCharts.put(a, new Program.OrgChart(a));
        }
        orgCharts.get('X').addDirectReports(new Program.OrgChart[] {orgCharts.get('Z')});
        return orgCharts;
    }


    public static void TestCase1() {
        var orgCharts = getOrgCharts();
        orgCharts
                .get('A')
                .addDirectReports(new Program.OrgChart[] {orgCharts.get('B'), orgCharts.get('C')});
        orgCharts
                .get('B')
                .addDirectReports(new Program.OrgChart[] {orgCharts.get('D'), orgCharts.get('E')});
        orgCharts
                .get('C')
                .addDirectReports(new Program.OrgChart[] {orgCharts.get('F'), orgCharts.get('G')});
        orgCharts
                .get('D')
                .addDirectReports(new Program.OrgChart[] {orgCharts.get('H'), orgCharts.get('I')});

        Program.OrgChart lcm =
                Program.getLowestCommonManager(orgCharts.get('A'), orgCharts.get('E'), orgCharts.get('I'));
    }


}

class Program {
    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo) {
        // Write your code here.

        List<OrgChart> path1 = new ArrayList<>();
        List<OrgChart> path2 = new ArrayList<>();
        return getLowestCommonManager(topManager,reportOne,reportTwo,path1,path2);
        //return topManager; // Replace this line.
    }

    public static OrgChart getLowestCommonManager(
            OrgChart topManager, OrgChart reportOne, OrgChart reportTwo, List<OrgChart> path1, List<OrgChart> path2) {
        getPath(topManager,reportOne,path1);
        getPath(topManager,reportTwo,path2);
        System.out.println(path1.toString());
        System.out.println(path2.toString());

        int i =0;

        while ( i < path1.size() && i < path2.size() && path1.get(i).equals(path2.get(i)))
        {
            i++;
        }

        return path1.get(i-1);

    }

    public static boolean getPath(OrgChart root, OrgChart r1, List<OrgChart> path)
    {
        boolean found = false;
        if ( root == r1)
        {path.add(root);
         return true;
        }
        for ( OrgChart c : root.directReports)
        { found = false;
            path.add(root);
            if ( c == r1)
            { found = false;
                path.add(c);
                return true;
            }
            else
                found = getPath( c, r1, path);
            if (found)
                break;
        }

        if (found)
            return true;
        else
        {  path.remove(path.size()-1);
            return false;
        }
    }

    static class OrgChart {
        public char name;
        public List<OrgChart> directReports;

        OrgChart(char name) {
            this.name = name;
            this.directReports = new ArrayList<OrgChart>();
        }

        // This method is for testing only.
        public void addDirectReports(OrgChart[] directReports) {
            for (OrgChart directReport : directReports) {
                this.directReports.add(directReport);
            }
        }
    }
}
