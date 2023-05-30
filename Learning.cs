using System.Collections;

namespace Learning
{
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

    class Element
    {
        public string Symbol { get; set; }
        public string Name { get; set; }
        public int AtomicNumber { get; set; }
    }
    class Utils
    {
        public static List<Element> BuildList()
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