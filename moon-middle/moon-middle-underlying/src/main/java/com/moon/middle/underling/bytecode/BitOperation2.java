package com.moon.middle.underling.bytecode;

/**
 * 位运算，实现加减乘除取模(+、-、*、/、%)
 * <p>
 * while方式实现
 * 
 * @author TobiasCui
 * @date 2018年11月5日 下午4:25:38
 * 
 */
public class BitOperation2 {
	/**
	 * 
	 * 
	 * 加法：将两个数看作是二进制数，利用:<br/>
	 * 1.相异（^）时，本位为1，进位为0； <br/>
	 * 2.同为1时本位为0，进位为1；同为0时，本位进位均为0;<br/>
	 * <p>
	 * 所以，不计进位的和为a^b，进位就是a&b,(与sum相加时先左移一位，因为这是进位）；完成加法直到进位为0。
	 * 
	 * @author TobiasCui
	 * @date 2018年11月5日 下午1:49:02
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b) {
		if (b == 0) {
			return a;
		}
		int result = 0;
		while (b != 0) {
			result = a ^ b;
			b = (a & b) << 1;
			a = result;
		}

		return result;
	}

	/**
	 * 减法：a-b
	 * 
	 * 由-b=+(-b)，~（b-1）=-b
	 * 
	 * 可得a-b=a+（-b）=a+(~(b-1))。把减法转化为加法即可。 减法：利用a+(-b)来实现，其中-b为补码，及取反再加一
	 * 
	 * @author TobiasCui
	 * @date 2018年11月5日 下午1:55:13
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int minus(int a, int b) {
		int b2 = ~(b - 1);
		return add(a, b2);
	}

	/**
	 * 二进制乘法: <br>
	 * {@code   1011 } <br>
	 * {@code * 1010(0010+1000) } <br>
	 * {@code -------- } <br>
	 * {@code  10110 (1011<<1,相当于乘以0010)  } <br>
	 * {@code  1011000 (1011<<3,相当于乘以1000)  } <br>
	 * {@code  --------  } <br>
	 * {@code  1101110 } <br>
	 * 
	 * 二进制乘法的原理是：从乘数的低位到高位，遇到1并且这个1在乘数的右起第i（i从0开始数）位，那么就把被乘数左移i位得到 temp_i
	 * 。直到乘数中的1遍历完后，把根据各位1而得到的被乘数的左移值们 temp_i 相加起来即得乘法结果。
	 * 
	 * 那么根据这个原理，可以得到实现代码：<br/>
	 * 这里要点为：用i记录当前遍历的乘数位,当前位为1则被乘数左移i位并加到和中，同时i++处理下一位；为0则乘数右移，i++，处理下一位......直到乘数==0说明乘数中的1遍历完了。此时把和返回即可。
	 * 
	 * @author TobiasCui
	 * @date 2018年11月5日 下午2:09:00
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int multi(int a, int b) {
		int i = 0;
		int res = 0;
		while (b != 0) {// 乘数为0则结束
			// 处理乘数当前位
			if ((b & 1) == 1) {
				res += (a << i);
				b = b >> 1;
				++i;// i记录当前位是第几位
			} else {
				b = b >> 1;
				++i;
			}
		}
		return res;
	}

	/**
	 * 除法：a/b
	 * 
	 * 除法的意义就在于：求a可以由多少个b组成。那么由此我们可得除法的实现：求a能减去多少个b，做减法的次数就是除法的商。
	 * 
	 * @author TobiasCui
	 * @date 2018年11月5日 下午2:06:04
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int sub(int a, int b) {
		int result = -1;
		if (a < b) {
			return 0;
		} else {
			result = sub(minus(a, b), b) + 1;
		}
		return result;
	}

	/**
	 * 除法：a/b
	 * 
	 * 除法的意义就在于：求a可以由多少个b组成。那么由此我们可得除法的实现：求a能减去多少个b，做减法的次数就是除法的商。
	 * 
	 * @author TobiasCui
	 * @date 2018年11月5日 下午2:06:04
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static int mod(int a, int b) {
		int result;
		if (a >= 0) {
			result = mod(minus(a, b), b);
		} else {
			return add(a, b);
		}
		return result;
	}

	public static void main(String[] args) {
		int a = -100, b = 10;
		System.out.println(add(a, b));
	}
}
