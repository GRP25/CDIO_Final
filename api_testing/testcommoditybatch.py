import json
from API.commoditybatch     import CommodityBatch

print('TESTING COMMODITYBATCH STARTED')

print('LIST1 test started!')
com_test    = CommodityBatch()
_list       = json.loads(com_test.list())
print(json.dumps(_list, indent=4))
print('LIST1 test complete!')

print('GET test started!')
max_combat  = max([x['commodityBatch_id'] for x in _list])
max_com     = max([x['commodity_id'] for x in _list])
print(max_combat)
obj         = com_test.get(max_combat)
print(obj)
print('GET test complete!')

print('LIST2 test started!')
com_test    = CommodityBatch()
_list       = json.loads(com_test.list(max_com))
print(json.dumps(_list, indent=4))
print('LIST2 test complete!')


print('CREATE test started!')
_id         = max_combat + 1
com_test.setJson(_id, 5, 13.5, 'Test Morten')
response    = com_test.create(com_test.json)
print(response)
print('CREATE test complete')

print('UPDATE test started!')
com_test.setJson(_id, 5, 10.1, 'Test Peter')
response    = com_test.update(com_test.json)
print(response)
print('UPDATE test complete')

print('TESTING COMMODITYBATCH COMPLETE')
