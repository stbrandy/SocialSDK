require(["sbt/connections/CommunityService", "sbt/dom", "sbt/json"], 
    function(CommunityService, dom, json) {
	var communityService = new CommunityService();
	var communityId = "%{sample.communityId}";
	communityService.getCommunity({
		id: communityId,		
		load: function(community){
			dom.setText("json", json.jsonBeanStringify(community));
		},
		error: function(error){
			dom.setText("json", json.jsonBeanStringify(error));
		}
	});
});