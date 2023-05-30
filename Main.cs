using System.Collections;
using System.Collections.Generic;
using Learning;

namespace CSAlgorithms
{

    class Program
    {
        static void Main(string[] args)
        {
            // LearnStringInterpolation();
            LearnCollections();
        }

        private static void LearnCollections()
        {

            var salmons = new List<string> { "chinook", "coho", "pink", "sockeye" };
            salmons.ForEach(salmon =>
            {
                // System.Console.WriteLine(salmon);
            });

            var galaxies = new List<Galaxy>()
            {
                new Galaxy(){Name = "what is this", MegaLightYears = 23},
                new Galaxy(){Name = "what is2this", MegaLightYears = 232},
                new Galaxy(){Name = "what is3 this", MegaLightYears = 233},
                new Galaxy(){Name = "what is 4this", MegaLightYears = 243},
            };
            foreach (var item in galaxies)
            {
                // System.Console.WriteLine($"{item.Name} : {item.MegaLightYears}");
            }

            Hashtable hashtable = new Hashtable();
            hashtable[0] = 2;
            hashtable[0] = 2;
            foreach (DictionaryEntry item in hashtable)
            {
                // System.Console.WriteLine($"{item.Key} => {item.Value}");
            }

            List<Element> elements = Utils.BuildList();
            // LINQ query
            var subset1 = from theElement in elements
                          where theElement.AtomicNumber < 32
                          orderby theElement.Name
                          select theElement;
            var subset2 = from el in elements
                          where el.AtomicNumber > 100 & el.AtomicNumber < 200
                          orderby el.Name
                          select el;
            foreach (var item in subset1)
            {
                // System.Console.WriteLine($"{item.Name} : {item.AtomicNumber}");
            }
            string testStr = "{}[]()";
            var stack = new Stack<char>();
            for (int i = 0; i < testStr.Length; i++)
            {
                char cur = testStr[i];
                if (stack.Count >= 1)
                {
                    char last = stack.Last();
                    if ((cur == last + 1) || (cur == last + 2))
                    {
                        stack.Pop();
                        continue;
                    }
                }
                stack.Push(cur);
            }
            // System.Console.WriteLine($"Is \"{testStr}\" a valid parenthesis: {stack.Count == 0}");
            var elementList = new AllElements();
            foreach (Element item in elementList)
            {
                System.Console.WriteLine(item.Name + " ");
            }

        }

        private static void LearnStringInterpolation()
        {
            int safetyScore = 85;
            string message = $"The usage policy for {safetyScore} is {safetyScore switch
            {
                > 90 => "Unlimited usage",
                > 80 => "General usage, with daily safety check",
                > 70 => "Issues must be addressed within 1 week",
                > 50 => "Issues must be addressed within 1 day",
                _ => "Issues must be addressed before continued use"
            }}";
            string name = "JackyStonk";
            DateTime today = DateTime.Now;
            string todayString = $"Whatzup, {name}! Today is {today:HH:mm:ss} now.";
            const int PIPrescision = 5;
            string PIString = $"PI num with {PIPrescision} precision: {Math.PI,PIPrescision}";
            System.Console.WriteLine(message);
            System.Console.WriteLine(todayString);
            System.Console.WriteLine(PIString);
        }

        // https://leetcode.com/problems/roman-to-integer/
        static int RomanToInt(string s)
        {
            int num = 0, prev = 0, ans = 0;
            for (int i = s.Length - 1; i >= 0; i--)
            {
                switch (s[i])
                {
                    case 'I': num = 1; break;
                    case 'V': num = 5; break;
                    case 'X': num = 10; break;
                    case 'L': num = 50; break;
                    case 'C': num = 100; break;
                    case 'D': num = 500; break;
                    case 'M': num = 1000; break;
                }
                if (num < prev)
                {
                    ans -= num;
                }
                else
                {
                    ans += num;
                }
                prev = num;
            }
            return ans;
        }

        // https://leetcode.com/problems/group-anagrams/
        static IList<IList<string>> GroupAnagrams(string[] strs)
        {
            Dictionary<string, List<string>> map = new Dictionary<string, List<string>>();
            IList<IList<string>> res = new List<IList<string>>();
            for (int i = 0; i < strs.Length; i++)
            {
                char[] charArr = strs[i].ToCharArray();
                Array.Sort(charArr);
                string sortedStr = new string(charArr);
                if (map.ContainsKey(sortedStr))
                {
                    map[sortedStr].Add(strs[i]);
                }
                if (!map.ContainsKey(sortedStr))
                {
                    List<string> newList = new List<string>() { strs[i] };
                    map[sortedStr] = newList;
                }
            }
            foreach (KeyValuePair<string, List<string>> item in map)
            {
                res.Add(item.Value);
            }
            return res;
        }

        // https://leetcode.com/problems/two-sum/
        static bool IsAnargram(string s, string t)
        {
            if (s.Length != t.Length)
            {
                return false;
            }
            int UNICODE_LEN = 512;
            int[] res = new int[UNICODE_LEN];
            for (int i = 0; i < s.Length; i++)
            {
                res[s[i]]++;
                res[t[i]]--;
            }
            for (int i = 0; i < UNICODE_LEN; i++)
            {
                if (res[i] != 0)
                {
                    return false;
                }
            }
            return true;
        }

        // https://leetcode.com/problems/two-sum/
        static int[]? twoSum(int[] nums, int target)
        {
            Dictionary<int, int> map = new Dictionary<int, int>();
            for (int i = 0; i < nums.Length; i++)
            {
                if (map.ContainsKey(target - nums[i]))
                {
                    return new int[] { map[target - nums[i]], i };
                }
            }
            return new int[0];
        }
    }

}

