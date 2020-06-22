import json
from API.commodity          import Commodity

print('TESTING COMMODITY STARTED')

print('LIST test started!')
com_test    = Commodity()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST test complete!')

print('GET test started!')
max_id      = max([x['commodity_id'] for x in _list])
print(max_id)
obj         = com_test.get(max_id)
print(obj)
print('GET test complete!')

print('CREATE test started!')
_id         = max_id + 1
com_test.setJson(f'CreateCommodityTest',_id)
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson(f'UpdateCommodityTest',_id)
response    = com_test.update(com_test.json)
print(response)
print('UPDATE test complete')

print('TESTING COMMODITY COMPLETE')
