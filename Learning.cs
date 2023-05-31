using System.Collections;

namespace Learning
{
    class DerivedLearnType : Learn
    {

    }

    class Learn
    {
        public static void LearnStringType()
        {
            string a = "hello";
            string b = "h";
            b += "ello";
            string stringLiterals = """
                This is a line from your concious, please consult to your master
                    to learn more about the syntax of this programming language called C#
                        I love this shit because "C#" is my first /language/ even before learnng "Java"
            """;
            // System.Console.WriteLine(a == b);
            // System.Console.WriteLine(object.ReferenceEquals(a, b));
        }

        public delegate int DelegateMethod(string str);
        public static int ConvertStringToInt(string str)
        {
            return int.Parse(str);
        }
        public static int ShowString(string str)
        {
            System.Console.WriteLine($"Show string: {str}");
            return 0;
        }
        public static int MostFrequent(int[] arr)
        {
            Dictionary<int, int> freq = new Dictionary<int, int>();
            int maxFreq = 0;
            int mostFreqNum = 0;

            for (int i = 0; i < arr.Length; i++)
            {
                if (!freq.ContainsKey(arr[i]))
                {
                    freq[arr[i]] = 1;
                }
                else
                {
                    freq[arr[i]]++;
                }

                if (freq[arr[i]] > maxFreq || (freq[arr[i]] == maxFreq && arr[i] < mostFreqNum))
                {
                    maxFreq = freq[arr[i]];
                    mostFreqNum = arr[i];
                }
            }
            return mostFreqNum;
        }
        public static void TestComplexLINQStyles()
        {
            var salesData = Utils.BuildSalesDataList();
            var result1 = salesData
                .Where(sales => sales.Quantity >= 10 && sales.Price >= 50)
                .GroupBy(sales => sales.Region)
                .Select(group => new
                {
                    Region = group.Key,
                    TotalSales = group.Sum(sales => sales.Quantity * sales.Price),
                    AveragePrice = group.Average(sales => sales.Price),
                    MaxQuantity = group.Max(sales => sales.Quantity),
                    MinPrice = group.Min(sales => sales.Price)
                })
                .OrderByDescending(group => group.TotalSales)
                .ToList();
            result1.ForEach(item => System.Console.WriteLine(item));
        }
    }
    class TestMotorcycle : Motorcycle
    {

        public override double GetTopSpeed()
        {

            return new Random().NextDouble() * 100;
        }

        public override int Drive(int miles, int speed)
        {
            return base.Drive(1, 19) + 99;
        }

        public static int ManipulateInt(ref int num)
        {
            return new Random().Next(1, 10) * num;
        }
        public static int? CheckDriverMentalScore(double speed)
        {
            int? score = null;
            return score;
        }
    }
    abstract class Motorcycle
    {
        public void StartEngine() { }
        protected void AddGas(int gallons) { }
        public virtual int Drive(int miles, int speed) { return 1; }
        public abstract double GetTopSpeed();
    }

    public class AllElements : System.Collections.IEnumerable
    {
        Element[] _elements ={
            new Element() { Name = "red" },
            new Element() { Name = "blue" },
            new Element() { Name = "green" }
        };

        IEnumerator IEnumerable.GetEnumerator()
        {
            return new ElementEnumerator(_elements);
            // return _elements.GetEnumerator();
        }

        public static IEnumerator<int> EvenSequence(int first, int last)
        {
            for (int i = first; i <= last; i++)
            {
                if (i % 2 == 0)
                {
                    yield return i;
                }
            }
        }

        private class ElementEnumerator : System.Collections.IEnumerator
        {
            private Element[] _elements;
            private int _position = -1;
            public ElementEnumerator(Element[] elements)
            {
                _elements = elements;
            }

            object IEnumerator.Current
            {
                get
                {
                    return _elements[_position];
                }
            }

            bool IEnumerator.MoveNext()
            {
                _position++;
                return (_position < _elements.Length);
            }

            void IEnumerator.Reset()
            {
                _position = -1;
            }
        }
    }

    enum BeveragePrice
    {
        Vodka = 500_000,
        Gin = 900_000,
        Rum = 1_200_000,
        Soju = 125_000,
    }

    class Galaxy
    {
        public string Name { get; set; }
        public int MegaLightYears { get; set; }
    }

    public class SalesData
    {
        public string Region { get; set; }
        public string Product { get; set; }
        public int Quantity { get; set; }
        public decimal Price { get; set; }
    }

    class Element
    {
        public string Symbol { get; set; }
        public string Name { get; set; }
        public int AtomicNumber { get; set; }
        public string FullName { get; set; }
    }
    class Utils
    {
        public static List<Element> BuildElementList()
        {
            return new List<Element>
            {
                new Element() { Symbol="K", Name="Potassium", AtomicNumber=19},
                new Element() { Symbol="Ca", Name="Calcium", AtomicNumber=20},
                new Element() { Symbol="Fe", Name="Scandium", AtomicNumber=231},
                new Element() { Symbol="Sc", Name="Metaniun", AtomicNumber=212},
                new Element() { Symbol="Br", Name="Jackarium", AtomicNumber=621},
                new Element() { Symbol="Ti", Name="Netalin", AtomicNumber=5},
                new Element() { Symbol="Sr", Name="Masterium", AtomicNumber=77},
                new Element() { Symbol="Zi", Name="Deltanium", AtomicNumber=12},
                new Element() { Symbol="C", Name="Carvibra", AtomicNumber=72},
            };
        }
        public static List<SalesData> BuildSalesDataList()
        {
            return new List<SalesData>
            {
                new SalesData { Region = "North", Product = "Product A", Quantity = 10, Price = 100 },
                new SalesData { Region = "North", Product = "Product B", Quantity = 20, Price = 50 },
                new SalesData { Region = "North", Product = "Product C", Quantity = 15, Price = 75 },
                new SalesData { Region = "South", Product = "Product A", Quantity = 5, Price = 120 },
                new SalesData { Region = "South", Product = "Product B", Quantity = 30, Price = 40 },
                new SalesData { Region = "South", Product = "Product C", Quantity = 25, Price = 60 },
                new SalesData { Region = "East", Product = "Product A", Quantity = 12, Price = 90 },
                new SalesData { Region = "East", Product = "Product B", Quantity = 18, Price = 55 },
                new SalesData { Region = "East", Product = "Product C", Quantity = 20, Price = 70 },
                new SalesData { Region = "West", Product = "Product A", Quantity = 8, Price = 110 },
                new SalesData { Region = "West", Product = "Product B", Quantity = 25, Price = 45 },
                new SalesData { Region = "West", Product = "Product C", Quantity = 30, Price = 55 }
            };
        }
    }

    class BaseAudit
    {
        public DateTime CreatedDate { get; }
        public DateTime UpdatedDate { get; set; }
        public DateTime DeletedDate { get; set; }

        public BaseAudit()
        {
            this.CreatedDate = DateTime.Now;
            this.UpdatedDate = DateTime.Now;
        }
    }

    class User
    {
        public string FirstName { get; private set; }
        public string LastName { get; init; }
        public string FullName { get; }

        public void Print() => System.Console.WriteLine($"{FirstName} {LastName} {FullName}");
    }

    class DerivedUser : User
    {
        public DerivedUser()
        {
            LastName = "Derived User";
        }
    }
    class Customer : BaseAudit
    {
        public string Name
        {
            get => _name;
            set
            {
                if (string.IsNullOrWhiteSpace(value))
                {
                    throw new ArgumentException("Name must not be blank");
                }
                _name = value;
            }
        }
        private string _name;
        public string? Email { get; init; }
        public string? Address { get; private set; }
        public decimal TotalPurchased { get; set; } = 0;
        private decimal TotalPurchasedTime = 0;

        public Customer(string contactName, string email, string address) : base()
        {
            Name = contactName;
            Email = email;
            Address = address;
        }

        public void buyAlcohol(BeveragePrice beverage)
        {
            // If bough more than 5 then discount -2%
            TotalPurchasedTime++;
            decimal price = (decimal)beverage;
            TotalPurchased += TotalPurchasedTime > 5 ? price * 98 / 100 : price;
        }

        public string toString() => Name + " " + Email + " " + Address;

        public void ChangeAddress(string newAddress) => Address = newAddress;
    }
}