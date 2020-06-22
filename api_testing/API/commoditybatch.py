import requests,json

class CommodityBatch:
    def setJson(self, combat_id, com_id, weight, supplier):
        self.json = {
                'commodityBatch_id': combat_id,
                'commodity_id': com_id,
                'weight': weight,
                'supplier': supplier,
                }

    def get(self, key):
        key = str(key)
        r = requests.get(f"https://api.mama.sh/commodityBatch/{key}")
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text

    def list(self, *args):
        if len(args) == 1:
            key = str(args[0])
            r = requests.get(f"https://api.mama.sh/commodityBatch/list/{key}")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text
        else:
            r = requests.get("https://api.mama.sh/commodityBatch")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text

    def create(self, obj):
        r = requests.post("https://api.mama.sh/commodityBatch", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/commodityBatch", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
