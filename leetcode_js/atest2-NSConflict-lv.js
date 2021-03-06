/**
 * @param {number} dividend
 * @param {number} divisor
 * @return {number}
 */
/**
 * @param {number[]} nums
 * @return {void} Do not return anything, modify nums in-place instead.
 */
/**
 * @param {string} s
 * @param {string[]} words
 * @return {number[]}
 */
var findSubstring = function(s, words) {
    var count = 0, dicts = [], start = 0, end = 0, 
    lens = words[0].length, res = [];
    for(var i in words){
        dicts[words[i]] = words[i] in dicts ? dicts[words[i]]+1 : 1;
    }
    for(var idx = 0; idx < s.length - lens + 1; idx++){
        var tmpdicts = {};
        var tmpidx = idx;
        while(tmpidx + lens <= s.length){
            word = s.slice(tmpidx, tmpidx + lens);
            if(word in dicts){
                tmpdicts[word] = word in tmpdicts ? tmpdicts[word]+1 : 1;
                if(tmpdicts[word] > dicts[word]){
                    break;
                }
            }else{
                break;
            }
            tmpidx += lens;
        }
        if( Math.floor((tmpidx - idx) / lens) == words.length){
            res.push(idx);
        } 
    }
    return res;
};
/**
 * Your NestedIterator will be called like this:
 * var i = new NestedIterator(nestedList), a = [];
 * while (i.hasNext()) a.push(i.next());
*/
var n = [1,2];
var m = findSubstring("barfoothefoobarman",["foo","bar"]);
console.log(m); 
