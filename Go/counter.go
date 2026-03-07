package main
import "fmt"
func main() {
	fmt.Println("hi")
}
/*
var a int = 3
var b = 4
c := 5

const Pi = 3.1415926
const (
	A = 1
	B = 2
)

var x int 
var can indicate the type of variable automatically
var x = 10
var s = hi

x := 10 : ":= " can only be used in function, and at least one new variable to be declared

func div(a, b int) (int, int){ (int, int) is the type of return value
	return a / b, a % b // can return many value
}
q, r := div(10, 3) -> q = 3, r = 1
q, _ := div(10, 3) -> q = 3;
" _ ", the symbol of space, which means this value is useless, and avoid complie error

In Go, declaring a variable but not use that is not allowed, so use "_" to take the place of those useless value

func read() (string, error){
	return "ok", nil
}

if n := 10; n > 5 { 
    fmt.Println(n)
}

if age <= 0{ // 中断式: return
	return
}
if age <= 18{
	return
}

&& if first condition is false, the second one will be skipped
|| if first is true, the second one will be skipped


for i := 0; i < 3; i++ { }      
for condition { }               
for { break }

while:
for i < 100{
	i ++
}

do-while
for{
	sum += i
	i++
	if i == 100{
		break
	}
}

switch x { (automatically break, if want to go through another condition, use fallthrough)
case 1,
case 2
...
default:
}

arr := [3]int{1, 2, 3} [n]int is a type of array, different length means different type
s := []{1, 2, 3} slice, a kind of dynamical array, length can be changed
s = append(s, 4) add 4 in the end and return the new s slice
t := make([]int, 0, 10) type: []int, length: 0, cap: 10, can append elements in the end

for i, v := range s {
    fmt.Println(i, v) // i is the index, v is the value
}

for _, v := range s { 
    _ = v
}

m := make(map[string]int) // the same as 'Map<String, Integer> m = new HashMap<>()' in Java;
m["a"] = 1 // key = "a"; value = 1

v, ok := m["b"] // two return value, v is the real value, and ok is a bool variable, 
if there is a string "b", ok == true, else false. If b doesn't exist, v will be 0
also, if there is a b's value is 0, "ok" will be true
delete(m, "a") // delete key

var userMap map[int]string = map[int]string{
	1: "ss",
	2: "ad",
	fmt.Println(userMap[1])
	value := userMap[1]
	value, ok := userMap[1]

}

type PodInfo struct {
    Name string
    UID  string
}
declare a new data type called PodInfo, two member variables: Name, UID, both types are string

p := PodInfo{Name: "p1"} // create a new PodInfo type variable p, p.Name == "p1", p.UID == ""
p.UID = "123" // p.UID == "123"

in Go, upper means public, lower means private

type Counter struct{ n int }

// 值接收者：拷贝一份
func (c Counter) Value() int { return c.n }

// 指针接收者：能修改原对象
func (c *Counter) Inc() { c.n++ }

init 
*/