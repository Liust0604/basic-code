package com.mori.course02.democollection;

import com.mori.course02.democollection.domain.GenericClass;
import com.mori.course02.democollection.domain.GenericMethod;
import com.mori.course02.democollection.domain.Person;
import com.mori.course02.democollection.domain.SchoolStudent;
import com.mori.course02.democollection.impl.GenericInterfaceImpl1;
import com.mori.course02.democollection.impl.GenericInterfaceImpl2;
import org.junit.Test;

import java.util.*;


public class CollectionDemo {

    /*****Collection*******/

    @Test
    /**
     * Collection 接口的共性方法
     * */
    public void Test01() {
        //多态的方式创建一个集合对象，接口指向实现类对象
        Collection<String> coll = new ArrayList<>();
        System.out.println(coll); //重写了toString方法

        coll.add("AAA"); //一般返回true
        coll.add("BBB");
        coll.add("CCC");
        System.out.println(coll);

        boolean removeFlag = coll.remove("AAA1"); //元素存在，删除成功，返回true；元素不存在，不会报错，删除失败，返回false；
        System.out.println(coll + " , " + removeFlag);

        boolean containsFlag = coll.contains("BBB");
        System.out.println(containsFlag);

        boolean isEmptyFlag = coll.isEmpty();
        int size = coll.size();
        System.out.println(size + " , " + isEmptyFlag);

        Object[] arr = coll.toArray(); //不能直接向下转型为String[]
        System.out.println(Arrays.toString(arr));

        coll.clear(); //清空元素，但不删除集合
        System.out.println(coll.size() + " , " + coll.isEmpty());
    }

    @Test
    /**
     * Iterator 集合的迭代器
     * */
    public void Test02() {
        //创建一个集合对象
        Collection<String> coll = new ArrayList<>();
        coll.add("AAA");
        coll.add("BBB");
        coll.add("CCC");
        coll.add("DDD");
        coll.add("EEE");

        //从Collector集合对象中获取属于该集合的迭代器，是Iterator接口的实现类对象
        //使用Iterator来承接（多态）
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) { //判断是否有下一个元素
            String e = it.next(); //取出下一个元素
            System.out.println(e);
        }
        //若没有元素，则hasNext()为false，再用next()取出元素，会报没有元素异常 java.util.NoSuchElementException

        System.out.println("-------");
        for (Iterator<String> it2 = coll.iterator(); it2.hasNext(); ) {
            String e = it2.next(); //取出下一个元素
            System.out.println(e);
        }

        System.out.println("-------");
        //forEach 增强for循环
        int[] arr = {1, 2, 3, 4, 5};
        for (int e : arr) {
            System.out.println(e);
        }

        ArrayList<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        for (String e : list) {
            System.out.println(e);
        }
    }

    @Test
    /**
     * 定义和使用含有泛型的类、方法、接口
     * */
    public void Test03() {
        //类
        GenericClass gc = new GenericClass();
        //不写泛型，默认返回Object类型
        gc.setName("SSS");
        Object obj = gc.getName();
        System.out.println(obj);

        //指定泛型的类型
        GenericClass<String> gc1 = new GenericClass<>();
        gc1.setName("SSS");
        String name1 = gc1.getName();
        System.out.println(name1);

        GenericClass<Integer> gc2 = new GenericClass<>();
        gc2.setName(1); //若这里不写指定的Integer类型的值，在编译时就会报红
        Integer name2 = gc2.getName();
        System.out.println(name2);

        System.out.println("-----------------");
        //方法
        GenericMethod gm = new GenericMethod(); //创建对象时不用指定泛型
        //调用方法时指定类型即可。传递什么类型，泛型就是什么类型
        gm.method(10);
        gm.method("AAA");

        GenericMethod.methodStatic('c'); //静态

        System.out.println("-----------------");
        //方法
        GenericInterfaceImpl1 impl1 = new GenericInterfaceImpl1();
        impl1.method("A");

        GenericInterfaceImpl2<Double> impl2 = new GenericInterfaceImpl2();
        impl2.method(123.3);

    }

    @Test
    /**
     * 泛型的通配符 ?
     * */
    public void Test04() {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("a");
        list2.add("b");
        //定义一个方法printArray，用于遍历所有类型的ArrayList
        //传入的ArrayList参数不确定泛型指定的什么类型，可以用泛型的通配符?来接收数据类型
        printArray(list1);
        printArray(list2);

        System.out.println("--------------");
        //高级用法:泛型的上限限定和泛型的下限限定
        //继承关系：Integer extends Number extends Object
        //        String extends Object

        Collection<Integer> coll1 = new ArrayList<>();
        Collection<Number> coll2 = new ArrayList<>();
        Collection<String> coll3 = new ArrayList<>();
        Collection<Object> coll4 = new ArrayList<>();

        //<? extends Number> 泛型的上限，不高于Number：Number、Integer
/*
        getElement1(coll1);
        getElement1(coll2);
        getElement1(coll3);
        getElement1(coll4);
*/

        //? super Number 泛型的下限，不低于Number：Number、Object
/*        getElement2(coll1);
        getElement2(coll2);
        getElement2(coll3);
        getElement2(coll4);*/

    }

    //若ArrayList<>指定泛型为特定类型，那么不能包含所有类型；若指定为Object，不可用，因为泛型是没有继承概念的，泛型指定什么就是什么，不会向上转型
    private void printArray(ArrayList<?> list) {
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            //it.next()方法取出的是Object，可以接收任意的数据类型
            Object o = it.next();
            System.out.println(o);
        }
    }

    //泛型的上限限定：也就是泛型都要继承自Number，也就是泛型为Number或Number的子类，也就是不能高与Number
    private void getElement1(Collection<? extends Number> coll) {
    }

    //泛型的下限限定，也就是要为Number的父类，也就是泛型为Number或Number的父类，也就是不能低于Number
    private void getElement2(Collection<? super Number> coll) {
    }

    /**
     * Collection 综合案例：斗地主
     * 1、准备牌：
     * 共54张牌：大王、小王、4种花色x13个序号的52张
     * 2、洗牌：java.util.Collections集合工具类的 shuffle() 方法，对列表元素随机置换
     * 3、发牌：轮流发一张，每人17张牌(可以用索引%3的方式确定轮流到谁)，留3张底牌
     */
    @Test
    public void collectionEx01() {
        //1
        List<String> cards = new ArrayList<>();
        cards.add("大王");
        cards.add("小王");

        String[] suits = {"♠", "♥", "♣", "♦"};
        String[] nums = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};
        for (String suit : suits) {
            for (String num : nums) {
                String card = suit + num;
                cards.add(card);
            }
        }

        //2
        Collections.shuffle(cards);

        //3
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        List<String> subCards = new ArrayList<>();

        for (int i = 0; i < cards.size(); i++) {
            String card = cards.get(i);
            if ((i + 1) <= 51) {
                if (i % 3 == 0) {
                    player1.add(card);
                } else if (i % 3 == 1) {
                    player2.add(card);
                } else if (i % 3 == 2) {
                    player3.add(card);
                }
            } else {
                subCards.add(card);
            }
        }

        System.out.println("玩家1" + player1);
        System.out.println("玩家2" + player2);
        System.out.println("玩家3" + player3);
        System.out.println("底牌" + subCards);
    }

    @Test
    /**
     * List方法
     * */
    public void Test05() {
        List<String> list = new ArrayList<>();
        //add(e) 是 collection 共性方法，只和元素有关。add(i，e)是List特有方法，和索引有关，元素添加到指定索引
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("a");
        System.out.println(list); //重写了toString方法
        list.add(3, "插入");
        System.out.println(list);

        //remove(e) 是 collection 共性方法，只和元素有关。remove(i)是List特有方法，和索引有关，删除指定索引所在的元素,并返回被移除的元素
        String removeE = list.remove(3);
        System.out.println(removeE + " , " + list);

        //set(i,e) 替换元素，并返回原元素。因为Collection，只知道有元素，并不知道元素位置，所以无法替换，下面也是无法根据位置获取元素索引无法for循环
        String setE = list.set(4, "A");
        System.out.println(setE + " , " + list);

        //get(i) 根据索引获取元素
        // 1、因为有get方法了，所以可以根据索引for循环
        for (int i = 0; i < list.size(); i++) {
            String e = list.get(i);
            System.out.println(e);
        }
        //2、迭代器
        Iterator<String> it = list.iterator(); //it 瑞 特
        while (it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
        //3、增强for
        for (String s : list) {
            System.out.println(s);
        }
    }

    @Test
    /**
     * LinkedList
     * */
    public void Test06() {
        //创建LinkedList集合对象,要用特有方法，所以不能用多态
        LinkedList<String> linked = new LinkedList<>();
        linked.add("a");
        linked.add("b");
        linked.add("c");
        linked.add("d");
        linked.add("a");
        System.out.println(linked);

        //linked.clear();
        //获取首尾元素
        if (!linked.isEmpty()) {
            System.out.println("------------");
            String first = linked.getFirst();
            String last = linked.getLast();
            System.out.println(first + " , " + last);
        }

        System.out.println("------------");
        //添加
        // addFirst 和 push 等效，入栈push一个元素，就是在插入数组的第一个
        linked.addFirst("s1");
        linked.push("s2");
        linked.addLast("e1"); //等效于add()
        System.out.println(linked);

        //移除
        System.out.println("------------");
        // firstRemove 和 pop 等效，弹栈第一个元素，就是移除数组第一个
        String firstRemove = linked.removeFirst();
        System.out.println("移除第一个：" + firstRemove);
        String popRemove = linked.pop();
        System.out.println("移除第一个：" + popRemove);
        String lastRemove = linked.removeLast();
        System.out.println("移除最后一个：" + lastRemove);
        System.out.println(linked);
    }

    @Test
    /**
     * HashSet
     * */
    public void Test07() {
        Set<Integer> set = new HashSet<>();
        //没有独有方法
        set.add(1);
        set.add(3);
        set.add(2);
        set.add(1);

        //没有索引，所以不能普通for循环，所以用迭代器或增强for
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer i = it.next();
            System.out.println(i); //1,2,3
        }
    }

    @Test
    /**
     * Set集合存储自定义元素
     * */
    public void Test08() {
        SchoolStudent s1 = new SchoolStudent("小红", 20);
        SchoolStudent s2 = new SchoolStudent("小红", 20);
        SchoolStudent s3 = new SchoolStudent("小红", 19);
        Set<SchoolStudent> set = new HashSet<>();
        set.add(s1);
        set.add(s2);
        set.add(s3);
        //若不重写，hash值不一定相同，equals比较对象物理地址，物理地址一定不同，所以肯定三个都重复。结果是三个都储存
        System.out.println(set);
        //重写了equals和hashCode方法
        //s1 s2 物理地址仍然不相同， == 返回false
        //重写后 hashCode() 有特定的处理方式，属性一样hashCode就想相同，hasCode() 返回true
        //重写后 equals比较的不是物理地址了，而是属性，equals() 返回 true
        //equals() 和 hashCode() 都相同，所以s1、s2重复。set中只保留2个对象
    }

    @Test
    /**
     * LinkedHashSet
     * */
    public void Test09() {
        LinkedHashSet<String> linked = new LinkedHashSet<>();
        linked.add("AAA");
        linked.add("444");
        linked.add("CCC");
        linked.add("444");
        linked.add("abc");
        System.out.println(linked); //有序存储,也不允许重复
    }

    @Test
    /**
     * TreeSet
     * */
    public void Test10() {
        //使用TreeSet，需要在自定义类里实现Comparable接口，并重写compareTo方法。
        //推荐用传入比较器参数的构造方法，匿名内部类Comparator接口，实现compare方法。
        TreeSet<SchoolStudent> treeSet = new TreeSet<>(new Comparator<SchoolStudent>() {
            @Override
            public int compare(SchoolStudent o1, SchoolStudent o2) {
                //从小到大排列，1,2,3 o2-o1<0成立
                return o1.getAge() - o2.getAge();
            }
        });
        SchoolStudent s1 = new SchoolStudent("小红", 20);
        SchoolStudent s2 = new SchoolStudent("小红", 16);
        SchoolStudent s3 = new SchoolStudent("小红", 19);
        treeSet.add(s1);
        treeSet.add(s2);
        treeSet.add(s3);
        //若自定义类不实现Comparable，不重写compareTo方法，会直接报错,不能转换成Comparable类
        System.out.println(treeSet); //有序存储,也不允许重复
    }

    @Test
    /**
     * 可变参数
     * */
    public void Test11() {
        //确定参数类型都是int，不确定多少个参数，所以可以使用可变参数
        System.out.println(add());
        System.out.println(add(1, 2, 3));
        System.out.println(add(5, 10, 13));
    }

    //计算多个整数的和
    public int add(int... arr) {
        //底层是一个数组，传递几个参数，就会创建一个多长的数组，存储所有参数
        System.out.println(arr.length + "  " + Arrays.toString(arr));
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }
        return sum;
    }

    @Test
    /**
     * Collections工具类
     * */
    public void Test12() {
        List<String> list = new ArrayList<>();
        //addAll一次性往集添加多个元素 可变参数
        Collections.addAll(list, "a", "b", "c", "d", "e");
        System.out.println(list);

        //打乱顺序
        Collections.shuffle(list);
        System.out.println(list);

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(2);
        //默认排序，升序
        Collections.sort(list1);
        System.out.println(list1);

        //自定义排序
        System.out.println("============================");
        List<SchoolStudent> list2 = new ArrayList<>();
        SchoolStudent s1 = new SchoolStudent("小红", 33);
        SchoolStudent s2 = new SchoolStudent("小红", 50);
        SchoolStudent s3 = new SchoolStudent("小红", 1);
        list2.add(s1);
        list2.add(s2);
        list2.add(s3);
        System.out.println(list2);
        //接口
        Collections.sort(list2);
        System.out.println(list2);
        //比较器
        Collections.sort(list2, new Comparator<SchoolStudent>() {
            @Override
            public int compare(SchoolStudent o1, SchoolStudent o2) {
                return o2.getAge() - o1.getAge(); //降序
            }
        });
        System.out.println(list2);
    }

    /*****Map*******/
    @Test
    /**
     * Map
     * */
    public void Test13() {
        //put 将指定键值对添加到Map集合中
        //key不存在，则返回null，key存在，替换value，并返回原value
        Map<String, String> map = new HashMap<>();

        String v1 = map.put("AAA", "value1");
        String v2 = map.put("AAA", "value2");
        System.out.println("v1:" + v1); //null
        System.out.println("v2:" + v2); //value1
        System.out.println(map); //{AAA=value2}

        map.put("BBB", "value1");
        map.put("CCC", "value2");

        System.out.println("-------------");
        //remove
        //key不存在，返回null(所以左侧要使用引用类型，防止空指针)，key存在，返回删除的value
        String r1 = map.remove("DDD");
        String r2 = map.remove("CCC");
        System.out.println("r1:" + r1); //null
        System.out.println("r2:" + r2); //value2
        System.out.println(map);

        System.out.println("-------------");
        //get
        //key不存在，返回null，key存在返回value
        String g1 = map.get("CCC");
        String g2 = map.get("BBB");
        System.out.println("g1:" + g1); //null
        System.out.println("g2:" + g2); //value1

        System.out.println("-------------");
        //containsKey
        //包含key返回true，不包含返回false
        System.out.println(map.containsKey("CCC"));
        System.out.println(map.containsKey("BBB"));

    }

    @Test
    /**
     * 遍历Map
     * */
    public void Test14() {
        Map<String, Integer> map = new HashMap<>();
        map.put("AAA", 111);
        map.put("BBB", 333);
        map.put("CCC", 222);

        //1、keySet()方法：把Map集合中的所有key取出，存储到Set中。
        // 遍历Set，可以用迭代器和增强for。
        // 遍历keySet获取key，get(key)获取value
        Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()) {
            String key = it.next();
            Integer value = map.get(key);
            System.out.println(key + "," + value);
        }

        System.out.println("----------------");
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            System.out.println(key + "," + value);
        }


        //2、entrySet()方法， Entry键值对对象
        System.out.println("----------------");
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Integer>> it2 = entrySet.iterator();
        while (it2.hasNext()) {
            Map.Entry<String, Integer> entry = it2.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "," + value);
        }
        System.out.println("----------------");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + "," + value);
        }

    }

    @Test
    /**
     * HashMap存储自定义元素
     * */
    public void Test15() {
        //1、key String ：String已经重写了equals和hashCode方法，所以保证了key唯一；key Person：Map的value可以重复，所以Person可随意

        //2、key Person：Person 必须手动重写equals和hashCode方法，保证key唯一。
        HashMap<Person, String> map = new HashMap();
        map.put(new Person("阿尔", 19), "美国");
        map.put(new Person("阿尔", 19), "America");
        map.put(new Person("亚瑟", 23), "英国");

        System.out.println(map);
    }


    @Test
    /**
     * LinkedHashMap 有序
     * */
    public void Test16() {
        HashMap<String, String> map = new LinkedHashMap();
        map.put("a", "美国");
        map.put("c", "America");
        map.put("b", "英国");
        System.out.println(map);
    }

    @Test
    /**
     * HashTable
     * */
    public void Test17() {
        HashMap<String, String> map1 = new HashMap(); //可null
        map1.put("a", null);
        map1.put(null, "b");
        map1.put(null, null);
        System.out.println(map1);

        Map<String, String> map2 = new Hashtable<>(); //不可为null，NullPointerException
        map2.put("a", null);
        map2.put(null, "b");
        map2.put(null, null);
        System.out.println(map2);
    }

    @Test
    /**
     * 练习：计算每字符串中每个字符出现的个数
     * */
    public void MapEx01() {
        System.out.print("请输入一个字符串：");
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(str);
        Map map = getCharNum(str);
        System.out.println(map);
    }

    public Map<Character, Integer> getCharNum(String str) {
        Map<Character, Integer> map = new HashMap<>();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }
            Integer num = map.get(c);
            map.put(c, ++num);
        }

        return map;
    }

    @Test
    /**
     * jdk9新特性： 对集合添加的优化
     * */
    public void Test18() {
        //List、Set、Map接口：添加了静态方法of，集合一次性添加多个元素，返回的集合不能再改变
        /*List<String> list = List.of("a", "b", "c");
        System.out.println(list);
        list.add("c");*/
    }

    /**
     * Debug测试
     */
    @Test
    public void Test19() {
        int a = 11;
        int b = 2;
        int sum = a + b;
        int mud = getMuxd(a, b);
        System.out.println("和：" + sum + " , " + "模：" + mud);
    }

    private int getMuxd(int a, int b) {
        return a % b;
    }

    @Test
    /**
     * 案例：斗地主：有序版本
     * 共54张牌：大王、小王、4种花色x13个序号的52张
     * List 保存索引，Map 保存索引和牌的对应关系
     * 打乱的不是牌是索引，发牌是发索引。排序是对索引进行排序，看牌查表法，玩家根据索引作为key去Map里找牌。
     * */
    public void MapEx02() {
        //1
        Map<Integer, String> cards = new HashMap<>();
        List<Integer> keys = new ArrayList<>();

        List<String> colors = Arrays.asList(new String[]{"♠", "♥", "♣", "♦"});
        List<String> nums = Arrays.asList(new String[]{"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"});
        int index = 0;
        for (String color : colors) {
            for (String num : nums) {
                String suit = color + num;
                cards.put(index, suit);
                keys.add(index++);
            }
        }
        cards.put(index, "小王");
        keys.add(index++);
        cards.put(index, "大王");
        keys.add(index++);

        //2
        Collections.shuffle(keys);

        //3
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> subCards = new ArrayList<>();

        for (int i = 0; i < keys.size(); i++) {
            Integer key = keys.get(i);
            if ((i + 1) <= 51) {
                if (i % 3 == 0) {
                    player1.add(key);
                } else if (i % 3 == 1) {
                    player2.add(key);
                } else if (i % 3 == 2) {
                    player3.add(key);
                }
            } else {
                subCards.add(key);
            }
        }

        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(subCards);

        showCard(cards, "玩家1", player1);
        showCard(cards, "玩家2", player2);
        showCard(cards, "玩家3", player3);
        showCard(cards, "底牌", subCards);
    }

    private List<String> showCard(Map<Integer, String> cards, String name, List<Integer> list) {
        List<String> res = new ArrayList<>();
        for (Integer key : list) {
            String suit = cards.get(key);
            res.add(suit);
        }
        System.out.println("姓名：" + name);
        System.out.println(res);
        return res;
    }
}
