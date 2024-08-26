// Problem: A. K-divisible Sum
// Contest: Codeforces - Educational Codeforces Round 103 (Rated for Div. 2)
// URL: https://codeforces.com/problemset/problem/1476/A
// Memory Limit: 256 MB
// Time Limit: 1000 ms
// 
// Powered by CP Editor (https://cpeditor.org)

#include <bits/stdc++.h>
using namespace std;
#define int long long int


void solve(){
	int n,k;
	cin>>n>>k;
	int l=n,r=1e9+5;
	int ans=1e9+5;
	if(n<=k){
		r=k;
		while(l<r){
			int md=(l+r)/2;
			//cout<<md<<"\n";
			if(k%md==0 || md%k==0){
				ans=min(ans,md);
				r=md;
			}
			else{
				l=md+1;
			}
		}
		ans=l;
	}
	else{	
	}
	cout<<ans<<"\n";
}

int32_t main()
{
	cin.tie(0);
    ios_base::sync_with_stdio(false);
	int t=1;
	cin>>t;
	while(t--)
		solve();
	
	return 0;
}
