using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Reflection;
using System.Runtime.ConstrainedExecution;
using System.Security.AccessControl;
using System.Text;
using System.Threading.Tasks;

namespace DFA
{
    class Program
    {

        public static Dictionary<char, Dictionary<char, char>> Matrix { get; set; }
        public static List<char> Endstateses { get; set; }

        public static char StartState { get; set; }


        static void Main(string[] args)
        {
            Endstateses=new List<char>();
            InitMatrix();
            StartState = 'A';
            Endstateses.Add('C');


            var tape = "zzzzzzzzzzxyz".ToCharArray();

            var res = Accept(tape);

            Console.WriteLine("Result: "+res);
            Console.ReadKey();


        }

        private static bool Accept(char[] argTape)
        {
            if (argTape == null) throw new ArgumentNullException("argTape");

            var state = StartState;

            foreach (var symb in argTape)
            {
                if (Matrix[state][symb] != ' ')
                {
                    state = Matrix[state][symb];
                    continue;
                }
                else
                {
                    return false;
                }
            }

            return Endstateses.Contains(state);


        }

        private static void InitMatrix()
        {
            Matrix=new Dictionary<char, Dictionary<char, char>>();
          
            Matrix.Add('A',new Dictionary<char, char> {{'x', 'B'}});
            Matrix['A'].Add('y',' ');
            Matrix['A'].Add('z', 'A');

            Matrix.Add('B', new Dictionary<char, char> { { 'x', ' ' } });
            Matrix['B'].Add('y', 'D');
            Matrix['B'].Add('z', 'C');


            Matrix.Add('C', new Dictionary<char, char> { { 'x', ' '} });
            Matrix['C'].Add('y', ' ');
            Matrix['C'].Add('z', ' ');


            Matrix.Add('D', new Dictionary<char, char> { { 'x', ' ' } });
            Matrix['D'].Add('y', ' ');
            Matrix['D'].Add('z', 'C');
        }
    }
}
