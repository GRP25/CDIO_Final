import json, requests

class ProductBatchComp:
    def setJson(self, probat_id, combat_id, user_id, tara, netto):
        self.json = {
                'productBatch_id': probat_id,
                'commodityBatch_id': combat_id,
                'user_id': user_id,
                'tara': tara,
                'netto': netto,
                }
    def get(self, product_id, commodity_id):
        params = {
                "productBatchId": product_id,
                "commodityBatchId": commodity_id,
                }
        r = requests.get("https://api.mama.sh/productbatchcomp/component", params=params)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text

    def list(self, *args):
        if len(args) == 1:
            key = str(args[0])
            r = requests.get(f"https://api.mama.sh/productbatchcomp/ID/{key}")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text
        else:
            r = requests.get("https://api.mama.sh/productbatchcomp")
            try:
                return json.dumps(json.loads(r.text), indent=4)
            except:
                return r.text

    def create(self, obj):
        r = requests.post("https://api.mama.sh/productbatchcomp", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
    def update(self, obj):
        r = requests.put("https://api.mama.sh/productbatchcomp", json=obj)
        try:
            return json.dumps(json.loads(r.text), indent=4)
        except:
            return r.text
