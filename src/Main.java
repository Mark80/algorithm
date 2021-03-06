import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {

    static Map<Integer, Set<Integer>> set = new HashMap<>();

    static String s =
            "73167176531330624919225119674426574742355349194934" +
                    "96983520312774506326239578318016984801869478851843" +
                    "85861560789112949495459501737958331952853208805511" +
                    "12540698747158523863050715693290963295227443043557" +
                    "66896648950445244523161731856403098711121722383113" +
                    "62229893423380308135336276614282806444486645238749" +
                    "30358907296290491560440772390713810515859307960866" +
                    "70172427121883998797908792274921901699720888093776" +
                    "65727333001053367881220235421809751254540594752243" +
                    "52584907711670556013604839586446706324415722155397" +
                    "53697817977846174064955149290862569321978468622482" +
                    "83972241375657056057490261407972968652414535100474" +
                    "82166370484403199890008895243450658541227588666881" +
                    "16427171479924442928230863465674813919123162824586" +
                    "17866458359124566529476545682848912883142607690042" +
                    "24219022671055626321111109370544217506941658960408" +
                    "07198403850962455444362981230987879927244284909188" +
                    "84580156166097919133875499200524063689912560717606" +
                    "05886116467109405077541002256983155200055935729725" +
                    "71636269561882670428252483600823257530420752963450";


    static String s1 = "37107287533902102798797998220837590246510135740250\n" +
            "46376937677490009712648124896970078050417018260538\n" +
            "74324986199524741059474233309513058123726617309629\n" +
            "91942213363574161572522430563301811072406154908250\n" +
            "23067588207539346171171980310421047513778063246676\n" +
            "89261670696623633820136378418383684178734361726757\n" +
            "28112879812849979408065481931592621691275889832738\n" +
            "44274228917432520321923589422876796487670272189318\n" +
            "47451445736001306439091167216856844588711603153276\n" +
            "70386486105843025439939619828917593665686757934951\n" +
            "62176457141856560629502157223196586755079324193331\n" +
            "64906352462741904929101432445813822663347944758178\n" +
            "92575867718337217661963751590579239728245598838407\n" +
            "58203565325359399008402633568948830189458628227828\n" +
            "80181199384826282014278194139940567587151170094390\n" +
            "35398664372827112653829987240784473053190104293586\n" +
            "86515506006295864861532075273371959191420517255829\n" +
            "71693888707715466499115593487603532921714970056938\n" +
            "54370070576826684624621495650076471787294438377604\n" +
            "53282654108756828443191190634694037855217779295145\n" +
            "36123272525000296071075082563815656710885258350721\n" +
            "45876576172410976447339110607218265236877223636045\n" +
            "17423706905851860660448207621209813287860733969412\n" +
            "81142660418086830619328460811191061556940512689692\n" +
            "51934325451728388641918047049293215058642563049483\n" +
            "62467221648435076201727918039944693004732956340691\n" +
            "15732444386908125794514089057706229429197107928209\n" +
            "55037687525678773091862540744969844508330393682126\n" +
            "18336384825330154686196124348767681297534375946515\n" +
            "80386287592878490201521685554828717201219257766954\n" +
            "78182833757993103614740356856449095527097864797581\n" +
            "16726320100436897842553539920931837441497806860984\n" +
            "48403098129077791799088218795327364475675590848030\n" +
            "87086987551392711854517078544161852424320693150332\n" +
            "59959406895756536782107074926966537676326235447210\n" +
            "69793950679652694742597709739166693763042633987085\n" +
            "41052684708299085211399427365734116182760315001271\n" +
            "65378607361501080857009149939512557028198746004375\n" +
            "35829035317434717326932123578154982629742552737307\n" +
            "94953759765105305946966067683156574377167401875275\n" +
            "88902802571733229619176668713819931811048770190271\n" +
            "25267680276078003013678680992525463401061632866526\n" +
            "36270218540497705585629946580636237993140746255962\n" +
            "24074486908231174977792365466257246923322810917141\n" +
            "91430288197103288597806669760892938638285025333403\n" +
            "34413065578016127815921815005561868836468420090470\n" +
            "23053081172816430487623791969842487255036638784583\n" +
            "11487696932154902810424020138335124462181441773470\n" +
            "63783299490636259666498587618221225225512486764533\n" +
            "67720186971698544312419572409913959008952310058822\n" +
            "95548255300263520781532296796249481641953868218774\n" +
            "76085327132285723110424803456124867697064507995236\n" +
            "37774242535411291684276865538926205024910326572967\n" +
            "23701913275725675285653248258265463092207058596522\n" +
            "29798860272258331913126375147341994889534765745501\n" +
            "18495701454879288984856827726077713721403798879715\n" +
            "38298203783031473527721580348144513491373226651381\n" +
            "34829543829199918180278916522431027392251122869539\n" +
            "40957953066405232632538044100059654939159879593635\n" +
            "29746152185502371307642255121183693803580388584903\n" +
            "41698116222072977186158236678424689157993532961922\n" +
            "62467957194401269043877107275048102390895523597457\n" +
            "23189706772547915061505504953922979530901129967519\n" +
            "86188088225875314529584099251203829009407770775672\n" +
            "11306739708304724483816533873502340845647058077308\n" +
            "82959174767140363198008187129011875491310547126581\n" +
            "97623331044818386269515456334926366572897563400500\n" +
            "42846280183517070527831839425882145521227251250327\n" +
            "55121603546981200581762165212827652751691296897789\n" +
            "32238195734329339946437501907836945765883352399886\n" +
            "75506164965184775180738168837861091527357929701337\n" +
            "62177842752192623401942399639168044983993173312731\n" +
            "32924185707147349566916674687634660915035914677504\n" +
            "99518671430235219628894890102423325116913619626622\n" +
            "73267460800591547471830798392868535206946944540724\n" +
            "76841822524674417161514036427982273348055556214818\n" +
            "97142617910342598647204516893989422179826088076852\n" +
            "87783646182799346313767754307809363333018982642090\n" +
            "10848802521674670883215120185883543223812876952786\n" +
            "71329612474782464538636993009049310363619763878039\n" +
            "62184073572399794223406235393808339651327408011116\n" +
            "66627891981488087797941876876144230030984490851411\n" +
            "60661826293682836764744779239180335110989069790714\n" +
            "85786944089552990653640447425576083659976645795096\n" +
            "66024396409905389607120198219976047599490197230297\n" +
            "64913982680032973156037120041377903785566085089252\n" +
            "16730939319872750275468906903707539413042652315011\n" +
            "94809377245048795150954100921645863754710598436791\n" +
            "78639167021187492431995700641917969777599028300699\n" +
            "15368713711936614952811305876380278410754449733078\n" +
            "40789923115535562561142322423255033685442488917353\n" +
            "44889911501440648020369068063960672322193204149535\n" +
            "41503128880339536053299340368006977710650566631954\n" +
            "81234880673210146739058568557934581403627822703280\n" +
            "82616570773948327592232845941706525094512325230608\n" +
            "22918802058777319719839450180888072429661980811197\n" +
            "77158542502016545090413245809786882778948721859617\n" +
            "72107838435069186155435662884062257473692284509516\n" +
            "20849603980134001723930671666823555245252804609722\n" +
            "53503534226472524250874054075591789781264330331690";

    public static void main(String[] args) {
        //System.out.println(sum());
        //System.out.println(sum());
        //System.out.println(fibonanacci_event_sum());
        //System.out.println(largePrimeFactor(new BigInteger("600851475143")));
//        System.out.println(isPalindorme(9009));
//        System.out.println(isPalindorme(1221));
//        System.out.println(isPalindorme(1223));
//        System.out.println(maxPalidrome());
//        System.out.println(5 * 7 * 8 * 9);
//        System.out.println(5 * 7 * 11 * 13 * 17 * 19 * 16 * 9);
//        System.out.println(((100 * 101) / 2) * ((100 * 101) / 2));
//        System.out.println(25502500 - 338350);
//        System.out.println(isPrime(6));
//        System.out.println(nPrimeNumber(10001));
//        System.out.println(product_13_number(13));
//        System.out.println(pitagora_triplette());
//        System.out.println(sumOfPrime(2_000_000));
//        System.out.println(number_of_divisor(500));
//        System.out.println(digitSum());
//        System.out.println(sumOfDigit());
        //338350
//        System.out.println(sequenceLength(1));
//        System.out.println(collatzSequence());
        //System.out.println(factorialLength());
        //       findPanDigital();

        //362880  1088640
        System.out.println(digitFactorials());        //362880  1088640
    }

    static long digitFactorials() {
        long[] facto = new long[9];

        for (int i = 0; i < facto.length; i++) {
            facto[i] = factorial2(i + 1);
        }

        long res = 0;
        for (int i = 1; i < 10000000; i++) {
            long sum = sumOfDigitFact(facto, i);
            if (sum == i) {
                res += i;
            }
        }
        return res - 3;

    }

    private static long sumOfDigitFact(long[] fact, int n) {
        String c = String.valueOf(n);
        long sum = 0;
        for (int j = 0; j < c.length(); j++) {
            int value = Integer.parseInt(c.substring(j, j + 1));
            if (value != 0) {
                sum += fact[value - 1];
            }else  {
                sum ++;
            }
        }
        return sum;
    }

    static void findPanDigital() {
        int l = 2;
        while (l < 10) {
            panDigital(l);
            l++;
            System.out.println(l);
        }
    }

    static void panDigital(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            str.append(i);
        }
        Set<String> permutation = permutationFinder(str.toString());
        long max = 0;
        for (String s : permutation) {
            long q = Long.parseLong(s);
            if (q > max && isPrime(q)) {
                max = q;
            }
        }

        System.out.println(max);


    }

    public static Set<String> permutationFinder(String str) {
        Set<String> perm = new HashSet<String>();
        if (str == null) {
            return null;
        } else if (str.length() == 0) {
            perm.add("");
            return perm;
        }
        char initial = str.charAt(0);
        String rem = str.substring(1);
        Set<String> words = permutationFinder(rem);
        for (String strNew : words) {
            for (int i = 0; i <= strNew.length(); i++) {
                perm.add(insertChar(strNew, initial, i));
            }
        }
        return perm;
    }

    public static String insertChar(String str, char c, int j) {
        String begin = str.substring(0, j);
        String end = str.substring(j);
        return begin + c + end;
    }

    static long nextPrime(long p) {
        long result = p + 2;
        while (isPrime(result)) {
            result = result + 2;
        }
        return result;
    }


    static void triangolarNumber() {
        for (int i = 0; i < 10000000; i++) {
            if ((i * (i + 1)) / 2 % 3 != 0)
                System.out.println(i);
        }
    }

    static int factorialLength(long n) {
        BigInteger integer = factorial(n);
        return sumOfDigitString(integer.toString());

    }

    private static BigInteger factorial(long n) {
        BigInteger integer = BigInteger.ONE;

        for (long i = 2; i <= n; i++) {
            integer = integer.multiply(BigInteger.valueOf(i));
        }
        return integer;
    }

    private static long factorial2(long n) {
        long integer = 1;

        for (long i = 2; i <= n; i++) {
            integer = integer * i;
        }
        return integer;
    }


    static long collatzSequence() {
        long result = 1;
        long n = 0;
        for (long i = 1; i <= 1_000_000; i++) {
            long count = sequenceLength(i);
            if (count > result) {
                result = count;
                n = i;
            }
        }
        return n;

    }

    static long sequenceLength(long n) {
        long count = 1;
        long currentValue = n;
        while (currentValue != 1) {
            if (currentValue % 2 == 0) {
                currentValue = currentValue / 2;
            } else {
                currentValue = (3 * currentValue) + 1;
            }
            count++;
        }
        return count;

    }

    static int sumOfDigit() {
        String r = BigInteger.TWO.pow(1000).toString();

        System.out.println(r);

        int res = sumOfDigitString(r);

        return res;
    }

    private static int sumOfDigitString(String r) {
        int res = 0;
        for (int i = 0; i < r.length(); i++) {
            int digit = Integer.parseInt(r.substring(i, i + 1));
            res += digit;
        }
        return res;
    }

    static String digitSum() {
        String[] nums = s1.split("\n");

        BigInteger r = BigInteger.ZERO;
        for (int i = 0; i < nums.length; i++) {
            BigInteger b = new BigInteger(nums[i]);
            r = r.add(b);
        }

        System.out.println(r);

        return r.toString().substring(0, 10);
    }


    static int sum() {
        var res = 0;

        for (int i = 1; i <= 100000; i++) {
            int sumOfDivisor = getSumOfDivisor(i);
            int sumOdDivDiv = getSumOfDivisor(sumOfDivisor);
            if (i == sumOdDivDiv && i != sumOfDivisor) {
                System.out.println(i + "," + sumOfDivisor);
                res = res + i;
            }

        }
        return res;
    }

    private static int getSumOfDivisor(int i) {
        var sumOfDivisor = 0;
        var count = i / 2;
        while (count > 0) {
            if (i % count == 0) {
                sumOfDivisor += count;
            }
            count--;
        }
        return sumOfDivisor;
    }

    static int multiple_3_5() {
        int res = 0;
        for (int i = 1; i < 1000; i++) {
            if (i % 3 == 0 || i % 5 == 0)
                res += i;
        }
        return res;
    }

    static long fibonanacci_event_sum() {
        long a = 0;
        long b = 1;
        long limit = 4_000_000;
        long res = 0;
        while (b < limit) {
            long fib = a + b;
            a = b;
            b = fib;
            if (fib % 2 == 0 && fib < limit) {
                res += b;
            }
        }

        return res;
    }

    static long largePrimeFactor(BigInteger value) {
        long max = 2;
        for (long i = 3; i < value.sqrt().longValue() + 1; i = i + 2) {
            if (isPrime(i) && value.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO))
                max = i;
        }
        return max;
    }

    static boolean isPrime(long n) {
        if (n == 1) return false;
        if (n == 2) return true;
        for (int i = 2; i < Math.floor(Math.sqrt(n)) + 1; i = i + 1) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static long maxPalidrome() {

        long max = 101;
        for (long i = 100; i <= 997; i++) {
            for (long j = i + 1; j <= 998; j++) {
                long r = i * j;
                if (isPalindorme(r) && r > max) {
                    max = r;
                }
            }

        }
        return max;
    }

    static boolean isPalindorme(long n) {
        String string = String.valueOf(n);
        for (int i = 0, j = string.length() - 1; i < j; i++, j--) {
            if (string.charAt(i) != string.charAt(j))
                return false;
        }
        return true;
    }

    static long nPrimeNumber(int n) {
        int count = 0;
        long num = 1;
        long prime = 0;
        while (count <= n) {
            if (isPrime(num)) {
                prime = num;
                count++;
            }
            num++;
        }
        return prime;
    }

    static long product_13_number(int d) {
        long res = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < 1000 - d; i++) {
            long tmp = 1;
            for (int k = i; k < i + d; k++) {
                tmp *= (Integer.parseInt(String.valueOf(arr[k])));
            }
            if (tmp > res) {
                res = tmp;
            }
        }
        return res;
    }

    static long pitagora_triplette() {

        for (long a = 1; a < 1000; a++) {
            for (long b = a + 1; b < 1000; b++) {
                long c = 1000 - (a + b);
                if (c > 0 && (a * a) + (b * b) == c * c) {
                    System.out.println(a);
                    System.out.println(b);
                    System.out.println(c);
                    return a * b * c;
                }
            }

        }

        return -1;
    }

    static long sumOfPrime(int n) {
        long res = 2;
        for (int i = 3; i < n; i = i + 2) {
            if (isPrime(i))
                res += i;
        }

        return res;

    }

    static long number_of_divisor(long d) {
        System.out.println("start .... ");

        long deep = 1;
        long t = 1;
        do {
            long count = 0;
            for (long i = 1; i <= t; i++) {
                if (t % i == 0) {
                    count++;
                }
                if (count > d)
                    return t;
            }
            t = t + deep + 1;
            deep++;

        } while (true);
    }


}
