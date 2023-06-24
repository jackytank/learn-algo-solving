function twoSum(nums: number[], target: number): number[] {
    const map = new Map<number, number>();
    let res: number[] = [];
    nums.forEach((n, i) => {
        const complement = target - n;
        if (map.has(complement)) {
            res = [map.get(complement)!, i];
        }
        map.set(n, i);
    });
    return res;
}

// main
(() => {
    console.log(twoSum([2, 7, 11, 15], 9));
})()

