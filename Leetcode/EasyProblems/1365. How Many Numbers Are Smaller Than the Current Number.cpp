class Solution {
public:
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        vector<int> v (nums) , ans;
        sort(v.begin() , v.end());
        for(int i = 0 ; i < nums.size() ; ++i)
        {
            int l = lower_bound(v.begin() , v.end() , nums[i]) - v.begin();
            ans.push_back(l);
        }
        return ans;
    }
};
